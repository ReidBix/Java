import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * GoogleMap
 * 
 * This class allows the user to do the following:
 * 1. loadGPSCoordinates - If you pass a properly-formed Google Directions URL to 
 * loadGPSCoordinates, an ArrayList of GPSCoordinates for that route will be returned.
 * 
 * 2. displayTravelMap - If you pass an ArrayList of GPSCoordinates to displayTravelMap,
 * a Google Map will be displayed with a travel line showing the route.
 * 
 * 3. displayPOIMap - If you pass a properly-formed Google Map URL to displayPOIMap,
 * a Google Map will be displayed with pins in the location for each point provided.
 * 
 * 
 * Format for loadGPSCoordinates URL - 
 * 
 * 1. Start with
 * "http://maps.googleapis.com/maps/api/directions/json?origin="
 * 
 * 2. Concatenate on the origin location, replacing all spaces in the name with a '+':
 * "http://maps.googleapis.com/maps/api/directions/json?origin=85+Engineers+Way,+
 * Charlottesville,+VA"
 * 
 * 3. Then add "&destination=" with the destination location, also replacing the spaces
 * as in Step 2:
 * "http://maps.googleapis.com/maps/api/directions/json?origin=85+Engineers+Way,+
 * Charlottesville,+VA&destination=Durham,+NC"
 * 
 * 4. For each waypoint, add them to the end, separated by |:
 * "http://maps.googleapis.com/maps/api/directions/json?origin=85+Engineers+Way,+
 * Charlottesville,+VA&destination=Durham,+NC&waypoints=Richmond,+VA|Raleigh,+NC"
 * 
 * 5. Finally, add "&sensor=false":
 * "http://maps.googleapis.com/maps/api/directions/json?origin=85+Engineers+Way,+
 * Charlottesville,+VA&destination=Durham,+NC&waypoints=Richmond,+VA|Raleigh,+NC&sensor=false"
 * 
 * 
 * How to use displayTravelMap - 
 * 
 * 1. Take the result of loadGPSCoordinates (the ArrayList of GPSCoordinates) and pass
 * it directly to this method.
 * 
 * ArrayList<GPSCoordinate> myCoordinateList = GoogleMap.loadGPSCoordinates(URL);
 * GoogleMap.displayTravelMap(myCoordinateList, 100, 100);
 * 
 * where 100,100 is the x,y point on your screen the image should show up.
 * 
 * 
 * Format for displayPOIMap URL -
 * 
 * The URL should be formatted as such:
 * 
 * 1. Start with
 * "http://maps.googleapis.com/maps/api/staticmap?size=1024x768&maptype=roadmap"
 * 
 * 2. For each coordinate color you have, you should group each of those sets of points
 * together.  First add the following to the end of the URL:
 * "&markers=color:green|"
 * replacing green with the color you want.
 * 
 * 3. Then, for each coordinate, put it's latitude and longitude next, with a comma:
 * "38.03607,-78.501914"
 * If you have more coordinates of that color, add a "|" and then the next coordinate:
 * "38.03607,-78.501914|38.03611,-78.502068"
 * 
 * 4. If you have another color set, add another:
 * "&markers=color:red|"
 * and repeat step 3.
 * 
 * 5. When you are done, you must end with "&sensor=false"
 * 
 * 6. An example URL might look like:
 * http://maps.googleapis.com/maps/api/staticmap?size=1024x768&maptype=roadmap
 * &markers=color:green|33.761654,-84.374260|33.748291,-84.391121|33.509548,-82.502342|
 * 33.728179,-82.717766|35.479550,-80.611910&markers=color:red|35.663520,-80.465620|
 * 34.044440,-81.121870|34.030650,-81.091250|33.995340,-81.033030|34.101920,-80.956470
 * &sensor=false
 * 
 * 5. To create the image, pass this URL to the displayPOIMap method:
 * GoogleMap.displayPOIMap(URL, "My Route", 100, 100);
 * 
 * where "My Route" will be in the title bar of the window and 100,100 is the x,y
 * where the image will appear on your screen.
 * 
 * NOTE: The max length of a URL is 2048 characters!  Check for this before calling this
 * method!!!
 * 
 * @author Mark Sherriff
 * 
 */
public class GoogleMap extends JPanel {

	// If you want to save the image to your project directory
	// with a random name, switch this to true
	private static final boolean SAVETODISK = false;

	// If you want the map image to display to the screen,
	// set this to true
	private static final boolean DISPLAYONSCREEN = true;

	// Class-level variables
	private int LARGESTHEIGHT = 0;
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	private Dimension size = new Dimension();
	
	public static void displayTravelMap(ArrayList<GPSCoordinate> list, int XLOC, int YLOC) {
		String polyLine = createEncodings(list, 17, 1);
		GoogleMap myMap = new GoogleMap();
		String polyLineURL = "http://maps.googleapis.com/maps/api/staticmap?size=1024x768&path=weight:3%7Ccolor:red%7Cenc:" + polyLine + "&sensor=false";
		myMap.createImage(polyLineURL, "My Trip",  XLOC,  YLOC);
	}
	
	public static void displayPOIMap(String URL, String title, int XLOC, int YLOC) {
		GoogleMap myMap = new GoogleMap();
		myMap.createImage(URL, title, XLOC, YLOC);
	}
	
	public static ArrayList<GPSCoordinate> loadGPSCoordinates(String URL) {
		String jsonText = "";
		
		try {
			Scanner input = new Scanner(new URL(URL).openStream());

			jsonText = "";
			while (input.hasNextLine()) {
				jsonText += input.nextLine();
			}
		} catch (Exception e) {
			System.err.println("Error caught loading website!");
			e.printStackTrace();
		}

		ArrayList<GPSCoordinate> list = new ArrayList<GPSCoordinate>();
		
		JSONParser parser = new JSONParser();
		KeyFinder finder = new KeyFinder();
		finder.setMatchKey("lat");
		try {
			while (!finder.isEnd()) {
				parser.parse(jsonText, finder, true);
				if (finder.isFound()) {
					finder.setFound(false);
					list.add(new GPSCoordinate((Double)finder.getValue(), 0));
				}
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		parser = new JSONParser();
		finder = new KeyFinder();
		finder.setMatchKey("lng");
		int counter = 0;
		try {
			while (!finder.isEnd()) {
				parser.parse(jsonText, finder, true);
				if (finder.isFound()) {
					finder.setFound(false);
					list.get(counter).setLon((Double)finder.getValue());
					counter++;
				}
			}
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.remove(0);
		
		
		for(int i = 0; i < list.size(); i+=2) {
			GPSCoordinate temp = list.remove(i);
			list.add(i+1, temp);
		}
		
		ArrayList<GPSCoordinate> returnList = new ArrayList<GPSCoordinate>();
		
		returnList.add(list.get(0));
		//System.out.println("----" + list.get(0));
		for(int i = 2; i < list.size(); i+=2) {
			returnList.add(list.get(i));
		}
		returnList.add(list.get(list.size()-1));
		

		return returnList;
	}
	
	// -------------------------------------------------------------------
	//
	// METHODS BEYOND THIS POINT WILL NOT BE CALLED BY THE USER IN THIS HW
	//
	// -------------------------------------------------------------------

	private void createImage(String url, String title, int XLOC, int YLOC) {

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		try {
			image = ImageIO.read(new URL(url));
			size.setSize(image.getWidth(), image.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (DISPLAYONSCREEN) {

			JFrame f = new JFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(new JScrollPane(this));
			f.setSize(size.width + 50, size.height + 50);
			f.setLocation(XLOC, YLOC);
			XLOC += image.getWidth() + 50;
			if (image.getHeight() > LARGESTHEIGHT) {
				LARGESTHEIGHT = image.getHeight() + 75;
			}
			if (XLOC > dim.getWidth() - image.getWidth() - 50) {
				YLOC += LARGESTHEIGHT;
				XLOC = 100;
			}
			f.setTitle(title);
			f.setVisible(true);
		}
		if (SAVETODISK) {

			Random rand = new Random();
			String imageName = title + (rand.nextInt() % 2000) +".png";

			File outputFile = new File(imageName);
			System.out.println("Saving to disk as: "
					+ outputFile.getAbsolutePath());
			try {
				ImageIO.write(image, "PNG", outputFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	


	/*
	 * Called by the graphics library - not called by the user
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	protected void paintComponent(Graphics g) {
		// Center image in this component.
		int x = (getWidth() - size.width) / 2;
		int y = (getHeight() - size.height) / 2;
		g.drawImage(image, x, y, this);
	}

	
	private static String createEncodings(ArrayList<GPSCoordinate> coordinateList, int level, int step) {

		HashMap<String, String> resultMap = new HashMap<String, String>();
		StringBuffer encodedPoints = new StringBuffer();
		StringBuffer encodedLevels = new StringBuffer();

		ArrayList<GPSCoordinate> trackpointList = coordinateList;

		int plat = 0;
		int plng = 0;
		int counter = 0;

		int listSize = trackpointList.size();

		GPSCoordinate trackpoint;

		for (int i = 0; i < listSize; i += step) {
			counter++;
			trackpoint = (GPSCoordinate) trackpointList.get(i);

			int late5 = floor1e5(trackpoint.getLat());
			int lnge5 = floor1e5(trackpoint.getLon());

			int dlat = late5 - plat;
			int dlng = lnge5 - plng;

			plat = late5;
			plng = lnge5;

			encodedPoints.append(encodeSignedNumber(dlat)).append(
					encodeSignedNumber(dlng));
			encodedLevels.append(encodeNumber(level));

		}


		resultMap.put("encodedPoints", encodedPoints.toString());
		resultMap.put("encodedLevels", encodedLevels.toString());
		
		
		return encodedPoints.toString();
	}
	
	private static String encodeSignedNumber(int num) {
		int sgn_num = num << 1;
		if (num < 0) {
			sgn_num = ~(sgn_num);
		}
		return (encodeNumber(sgn_num));
	}

	private static String encodeNumber(int num) {

		StringBuffer encodeString = new StringBuffer();

		while (num >= 0x20) {
			int nextValue = (0x20 | (num & 0x1f)) + 63;
			encodeString.append((char) (nextValue));
			num >>= 5;
		}

		num += 63;
		encodeString.append((char) (num));

		return encodeString.toString();
	}
	
	private static int floor1e5(double coordinate) {
		return (int) Math.floor(coordinate * 1e5);
	}
	
	


}
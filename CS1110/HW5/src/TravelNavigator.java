/**
 * Names: Reid Bixler, Camille Hochheimer
 * Computing IDs: rmb3yz, cjh8uc
 * Lab Section: 1110-102
 * Date: October 20, 2013
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TravelNavigator {

	public static void main(String[] args) throws IOException {
		System.out.println("----- Travel Navigator ------");

		Scanner key = new Scanner(System.in);

		ArrayList<String> URL = new ArrayList<String>();
		URL.add("http://maps.googleapis.com/maps/api/directions/json?origin="); // initial
																				// URL

		System.out.print("Origin: "); // Asks for the start point
		String origin = key.nextLine();
		String[] originarray = origin.split(" "); // Split the point given
		int originlength = originarray.length;
		for (int i = 0; i < originlength - 1; ++i) {
			URL.add(originarray[i]); // Add words with '+' instead of ' ' into
										// URL
			URL.add("+");
		}
		URL.add(originarray[originlength - 1]); // add final word without "+"
		URL.add("&destination="); // second part of URL

		System.out.print("Destination: "); // Asks for the end point
		String destination = key.nextLine();
		String[] destinationarray = destination.split(" ");
		int destinationlength = destinationarray.length;
		for (int i = 0; i < destinationlength - 1; ++i) { // repeat of start
															// words process but
															// with end
			URL.add(destinationarray[i]);
			URL.add("+");
		}
		URL.add(destinationarray[destinationlength - 1]);
		URL.add("&waypoints="); // third part of URL

		String URLstring = ""; // creates the ACTUAL URL (not an array or
								// list)

		for (int i = 1; i > 0; ++i) {
			System.out.print("Waypoint " + i + " (x for no more waypoints): "); // Asks
																				// for
																				// a
																				// waypoint
			String waypoint = key.nextLine();

			if (waypoint.equals("x")) { // if x, then stops asking for waypoints
				break;
			}

			if (i >= 2) { // if more than one waypoint, add "|"
				URL.add("|");
			}

			String[] waypointarray = waypoint.split(" "); // if not, repeat
															// process of words
			int waypointlength = waypointarray.length;
			for (int i1 = 0; i1 < waypointlength - 1; ++i1) {
				URL.add(waypointarray[i1]);
				URL.add("+");
			}
			URL.add(waypointarray[waypointlength - 1]);// last word without "+"

		}

		URL.add("&sensor=false");// last part of URL

		for (int i = 0; i < URL.size(); ++i) { // turns URL list into a single
												// string for an actual URL
			URLstring += URL.get(i);
		}

		System.out.println(URLstring); // Prints the actual URL

		// uses GoogleMap.java to turn the actual URL into a list of coordinates
		ArrayList<GPSCoordinate> list = GoogleMap.loadGPSCoordinates(URLstring);

		// creates new coordinates if more than 5 miles apart
		for (int i = 0; i < list.size() - 1; ++i) {// by the size of the list of
													// coordinates (-1 so it
													// doesn't go past the list
													// size)
			GPSCoordinate pt1 = list.get(i);// takes the one coordinate
			GPSCoordinate pt2 = list.get(i + 1);// and then the next coordinate
												// after

			double dist = pt1.distanceTo(pt2);// and finds the distance
												// between them

			double brng = pt1.getBearing(pt2);// and a bearing from one to
												// the next

			if (dist > 5.0) {// if the distance is greater than 5 miles
				// create a coordinate five miles away
				GPSCoordinate pt3 = pt1.findCoordinate(brng, 5);
				// add the coordinate in between pt1 and pt2
				list.add(i + 1, pt3);
			}
		}

		// takes the coordinates and the NEW coordinates made previously and
		// turns them into a map using GoogleMap.java
		GoogleMap.displayTravelMap(list, 100, 100);

		// Trying for Extra Credit

		// stuff for opening json
		URL myWebPage = new URL(URLstring);
		Scanner myWebReader = new Scanner(myWebPage.openStream());

		// finds end address
		String endAddress = "\"end_address\" :";

		// initializing variable for later
		int lineCount = 0;
		int lineWithEnd = 0;
		String line2 = "";
		double totSec = 0;

		// reads the json
		while (myWebReader.hasNextLine()) {
			String line = myWebReader.nextLine();
			// finds all the lines that contain words end address
			if (line.contains(endAddress)) {
				// finds the line number where it contains it
				lineWithEnd = lineCount;
				// opens a new webreader of same file
				Scanner myWebReader2 = new Scanner(myWebPage.openStream());
				// finds the line that contains time in seconds (1 back from end
				// address)
				for (int i = 0; i < lineWithEnd - 1; ++i) {
					line2 = myWebReader2.nextLine();
				}
				// saves that final line with total seconds and splits it where
				// it only has 2 parts, 1st part is unnecessary and the second
				// has the total seconds
				String[] arrayOfLine2 = line2.split(": ");
				// turns the string of the second part (seconds) into a double
				double sec = Double.parseDouble(arrayOfLine2[1]);
				// adds those seconds (time from one point to next point) to
				// total time
				totSec += sec;
				// closes webreader for next time
				myWebReader2.close();
			}
			// counts the number of lines in the file for use of finding total
			// time
			lineCount += 1;
		}

		// complicated math that is kind of dumb but gets the answer eventually
		double totTimeinMin = totSec / 60;
		double totTimeinHr = totTimeinMin / 60;

		double totalMinbyHr = totTimeinHr % 1;
		int finalHr = (int) (totTimeinHr - totalMinbyHr);

		double totalMin = totalMinbyHr * 60;

		double totalSecbyMin = totalMin % 1;
		int finalMin = (int) (totalMin - totalSecbyMin);

		int finalSec = (int) (totalSecbyMin * 60);

		// FINDS THE FINAL TIME
		System.out.println("\nTotal trip time is " + finalHr + "h " + finalMin
				+ "m " + finalSec + "s");

		myWebReader.close();

		// ask user for csv filename
		System.out.println("\nWhich POI file do you want to map?\n");

		// checks for csv files and prints list of them
		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; ++i) {
			if (listOfFiles[i].isFile()
					&& listOfFiles[i].getName()
							.substring(listOfFiles[i].getName().length() - 4)
							.equals(".csv")) {
				System.out.println(listOfFiles[i].getName());
			}
		}

		// asks for the name of the file the user would like to read from
		System.out.print("\nFilename: ");
		String fileName = key.nextLine();

		// asks the user for the range from the route they would like the POI's
		System.out.print("\nDistance to POI?: ");
		double distPOI = key.nextDouble();

		// tells user that it takes a while, because it does
		System.out
				.println("\nPlease give it a couple of minutes, there are a lot of coordinates to check.");
		System.out
				.println("Depending on the size of the csv file and the distance to the POI, it may take a while.");
		System.out
				.println("A map of the points of interest will pop up when it is completed.\n");

		// creates the file from the given filename
		File myFile = new File(fileName);

		// Creates a list of GPSCoordinates to prevent repeated POI's
		ArrayList<GPSCoordinate> coordCheckList = new ArrayList<GPSCoordinate>();

		// trying same thing as phone stop but with coord
		int coordStop = 0;

		// initializing some variables
		String duplicateCoordString = "";
		String pt2CheckString = "";

		// FOR POI MAP
		String poiURL = "";
		ArrayList<String> poiList = new ArrayList<String>();
		poiList.add("http://maps.googleapis.com/maps/api/staticmap?");
		poiList.add("size=1024x768");// could be possible to change size
		poiList.add("&maptype=roadmap");
		poiList.add("&markers=color:green");// or color if need be

		if (fileName.equals("dairyqueen.csv") // Creates points of interest if
												// DQ, MCD, or W because they
												// have a certain format in the
												// csv file
				|| fileName.equals("mcdonalds.csv")
				|| fileName.equals("wendys.csv")) {

			for (int i = 0; i < list.size(); ++i) {// for every point from the
													// URL
				// create a reader for the chosen csv file
				Scanner myFileReader = new Scanner(myFile);
				// create a point to check a distance from a POI
				GPSCoordinate ptCheck = list.get(i);

				// checks all points in the csv file for a single point from the
				// URL
				while (myFileReader.hasNextLine()) {
					// create a line to do stuff with
					String line = myFileReader.nextLine();
					// makes a list to be used for information of points from
					// csv
					ArrayList<String> listOfInfo = new ArrayList<String>();
					// makes a single string to be used for info of points from
					// csv
					String stringOfInfo = "";
					// makes an array from the current line
					String[] arrayOfInfo = line.split(",");

					// for how long the array is, add those elements to the list
					for (int i4 = 0; i4 < arrayOfInfo.length; ++i4) {
						listOfInfo.add(arrayOfInfo[i4]);
					}
					// add extra elements at the end of the list to prevent
					// errors
					listOfInfo.add(" ");
					listOfInfo.add(" ");
					listOfInfo.add(" ");
					listOfInfo.add(" ");

					// for how long the list is, take all the elements of the
					// list and put them into a single line split by ";"
					for (int i6 = 0; i6 < listOfInfo.size() - 1; ++i6) {
						stringOfInfo += listOfInfo.get(i6);
						stringOfInfo += ";";
					}

					// takes the string of info and splits it along ";" into an
					// array
					String[] filearray = stringOfInfo.split(";");

					// longitude and latitude of POI
					double lat = Double.parseDouble(filearray[0]);
					double lon = Double.parseDouble(filearray[1]);
					// creates a coordinate to check distance from lat and long
					GPSCoordinate pt2Check = new GPSCoordinate(lat, lon);
					// Name of the establishment
					String name = filearray[2];
					// State
					String state = filearray[3];
					// Street Address
					String address = filearray[4];
					// City
					String city = filearray[5];
					// Repeat of State
					String state2 = filearray[6];
					// Phone #
					String phone = filearray[7];

					// creates a distance to check if within the parameters
					double distCheck = ptCheck.distanceTo(pt2Check);

					// remakes the variable coordStop so that it can be if
					// needed in the next loop coordStop = 0;
					coordStop = 0;

					// uses the 'coord check list' created before and if the
					// coord is a duplicate, it will make the coordStop = 1,
					// preventing the repitition of multiple POI's
					for (int i3 = 0; i3 < coordCheckList.size(); ++i3) {
						GPSCoordinate duplicateCoord = coordCheckList.get(i3);
						duplicateCoordString = duplicateCoord.toString();
						pt2CheckString = pt2Check.toString();
						if (duplicateCoordString.equals(pt2CheckString)) {
							coordStop = 1;
							break;
						}

					}

					// as long as the distance between the point from the URL
					// and the POI is in the range given AND the coordStop
					// doesn't say that the location has been printed before,
					// will print the location
					if (distCheck <= distPOI && coordStop == 0) {
						System.out
								.println(pt2Check + " - " + name + "," + state
										+ " - " + address + ", " + city + ","
										+ state2 + ", " + phone + " is near "
										+ ptCheck);
						// turns the coordinates of the POI into a string and
						// adds it to the URL for the POI map
						String pt2URL = pt2Check.getCoordinate();
						poiList.add("|");
						poiList.add(pt2URL);
						// prevents this coordinate from being printed again /
						// any repeats
						coordCheckList.add(pt2Check);
					}

				}
				myFileReader.close();
			}

		} else if (fileName.equals("starbucks.csv")// If SB or WM because have a
													// different formatting
													// because it's DUMB
				|| fileName.equals("walmart.csv")) {

			for (int i = 0; i < list.size(); ++i) {// for every point from the
				// URL
				// create a reader for the chosen csv file
				Scanner myFileReader = new Scanner(myFile);
				// create a point to check a distance from a POI
				GPSCoordinate ptCheck = list.get(i);

				// checks all points in the csv file for a single point from the
				// URL
				while (myFileReader.hasNextLine()) {
					// create a line to do stuff with
					String line = myFileReader.nextLine();
					// makes a list to be used for information of points from
					// csv
					ArrayList<String> listOfInfo = new ArrayList<String>();
					// makes a single string to be used for info of points from
					// csv
					String stringOfInfo = "";
					// makes an array from the current line
					String[] arrayOfInfo = line.split(",");

					// for how long the array is, add those elements to the list
					for (int i4 = 0; i4 < arrayOfInfo.length; ++i4) {
						listOfInfo.add(arrayOfInfo[i4]);
					}
					// add extra elements at the end of the list to prevent
					// errors
					listOfInfo.add(" ");
					listOfInfo.add(" ");
					listOfInfo.add(" ");
					listOfInfo.add(" ");

					// for how long the list is, take all the elements of the
					// list and put them into a single line split by ";"
					for (int i6 = 0; i6 < listOfInfo.size() - 1; ++i6) {
						stringOfInfo += listOfInfo.get(i6);
						stringOfInfo += ";";
					}

					// takes the string of info and splits it along ";" into an
					// array
					String[] filearray = stringOfInfo.split(";");

					// longitude and latitude of POI
					double lat = Double.parseDouble(filearray[0]);
					double lon = Double.parseDouble(filearray[1]);
					// creates a coordinate to check distance from lat and long
					GPSCoordinate pt2Check = new GPSCoordinate(lat, lon);
					// Name of the establishment
					String name = filearray[2];
					// Street Address
					String address = filearray[3];
					// City
					String city = filearray[4];
					// State & Zip
					String state = filearray[5];
					// Phone #
					String phone = filearray[6];

					// creates a distance to check if within the parameters
					double distCheck = ptCheck.distanceTo(pt2Check);

					// remakes the variable coordStop so that it can be if
					// needed in the next loop coordStop = 0;
					coordStop = 0;

					// uses the 'coord check list' created before and if the
					// coord is a duplicate, it will make the coordStop = 1,
					// preventing the repitition of multiple POI's
					for (int i3 = 0; i3 < coordCheckList.size(); ++i3) {
						GPSCoordinate duplicateCoord = coordCheckList.get(i3);
						duplicateCoordString = duplicateCoord.toString();
						pt2CheckString = pt2Check.toString();
						if (duplicateCoordString.equals(pt2CheckString)) {
							coordStop = 1;
							break;
						}

					}

					// as long as the distance between the point from the URL
					// and the POI is in the range given AND the coordStop
					// doesn't say that the location has been printed before,
					// will print the location
					if (distCheck <= distPOI && coordStop == 0) {
						System.out.println(pt2Check + " - " + name + ","
								+ state + " - " + address + ", " + city + ","
								+ state + ", " + phone + " is near " + ptCheck);
						// turns the coordinates of the POI into a string and
						// adds it to the URL for the POI map
						String pt2URL = pt2Check.getCoordinate();
						poiList.add("|");
						poiList.add(pt2URL);
						// prevents this coordinate from being printed again /
						// any repeats
						coordCheckList.add(pt2Check);
					}

				}
				myFileReader.close();
			}

		}

		else {// LAST RESORT IF FOR SOME STUPID REASON THEY GIVE US SOME
				// OTHER CSV FILE, HOPING IT HAS THE SAME FORMAT AS WENDY'S
			for (int i = 0; i < list.size(); ++i) {// for every point from the
				// URL
				// create a reader for the chosen csv file
				Scanner myFileReader = new Scanner(myFile);
				// create a point to check a distance from a POI
				GPSCoordinate ptCheck = list.get(i);

				// checks all points in the csv file for a single point from the
				// URL
				while (myFileReader.hasNextLine()) {
					// create a line to do stuff with
					String line = myFileReader.nextLine();
					// makes a list to be used for information of points from
					// csv
					ArrayList<String> listOfInfo = new ArrayList<String>();
					// makes a single string to be used for info of points from
					// csv
					String stringOfInfo = "";
					// makes an array from the current line
					String[] arrayOfInfo = line.split(",");

					// for how long the array is, add those elements to the list
					for (int i4 = 0; i4 < arrayOfInfo.length; ++i4) {
						listOfInfo.add(arrayOfInfo[i4]);
					}
					// add extra elements at the end of the list to prevent
					// errors
					listOfInfo.add(" ");
					listOfInfo.add(" ");
					listOfInfo.add(" ");
					listOfInfo.add(" ");

					// for how long the list is, take all the elements of the
					// list and put them into a single line split by ";"
					for (int i6 = 0; i6 < listOfInfo.size() - 1; ++i6) {
						stringOfInfo += listOfInfo.get(i6);
						stringOfInfo += ";";
					}

					// takes the string of info and splits it along ";" into an
					// array
					String[] filearray = stringOfInfo.split(";");

					// longitude and latitude of POI
					double lat = Double.parseDouble(filearray[0]);
					double lon = Double.parseDouble(filearray[1]);
					// creates a coordinate to check distance from lat and long
					GPSCoordinate pt2Check = new GPSCoordinate(lat, lon);
					// Name of the establishment
					String name = filearray[2];
					// State
					String state = filearray[3];
					// Street Address
					String address = filearray[4];
					// City
					String city = filearray[5];
					// Repeat of State
					String state2 = filearray[6];
					// Phone #
					String phone = filearray[7];

					// creates a distance to check if within the parameters
					double distCheck = ptCheck.distanceTo(pt2Check);

					// remakes the variable coordStop so that it can be if
					// needed in the next loop coordStop = 0;
					coordStop = 0;

					// uses the 'coord check list' created before and if the
					// coord is a duplicate, it will make the coordStop = 1,
					// preventing the repitition of multiple POI's
					for (int i3 = 0; i3 < coordCheckList.size(); ++i3) {
						GPSCoordinate duplicateCoord = coordCheckList.get(i3);
						duplicateCoordString = duplicateCoord.toString();
						pt2CheckString = pt2Check.toString();
						if (duplicateCoordString.equals(pt2CheckString)) {
							coordStop = 1;
							break;
						}

					}

					// as long as the distance between the point from the URL
					// and the POI is in the range given AND the coordStop
					// doesn't say that the location has been printed before,
					// will print the location
					if (distCheck <= distPOI && coordStop == 0) {
						System.out
								.println(pt2Check + " - " + name + "," + state
										+ " - " + address + ", " + city + ","
										+ state2 + ", " + phone + " is near "
										+ ptCheck);
						// turns the coordinates of the POI into a string and
						// adds it to the URL for the POI map
						String pt2URL = pt2Check.getCoordinate();
						poiList.add("|");
						poiList.add(pt2URL);
						// prevents this coordinate from being printed again /
						// any repeats
						coordCheckList.add(pt2Check);
					}

				}
				myFileReader.close();
			}
		}
		// adds the final part for the POI map
		poiList.add("&sensor=false");

		// turns the list of things for the POI map into a string/URL
		for (int i = 0; i < poiList.size(); ++i) {
			poiURL += poiList.get(i);
		}

		// checks the length of said URL, if it's greater than 2048 characters
		// then it won't be usable
		int poiURLLength = poiURL.length();

		// if too many characters
		if (poiURLLength > 2048) {
			System.out.println("\n" + poiURL);

			System.out.println("Too many points to put on the map!");
		}

		// prints POI map if within bounds of characters
		else if (poiURLLength < 2048) {
			System.out.println("\n" + poiURL);

			GoogleMap.displayPOIMap(poiURL, "My Route", 100, 100);
		}

		// says DONE! because I like for it to say done
		System.out.println("\nDONE!");

		// final close for any warnings
		key.close();
	}

}

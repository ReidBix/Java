import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ZipCodes {

	public static void main(String[] args) throws IOException {
		
		Scanner key = new Scanner(System.in);
		System.out.print("What zip code do you want to display?: ");
		String zip = key.next();
		
		
		String fname = "zipcodes.csv";
		File file = new File(fname);
		Scanner fileread = new Scanner(file);
		Scanner fileread2 = new Scanner(file);
		
		fileread.nextLine();
		fileread2.nextLine();
		
		String URL = "http://maps.googleapis.com/maps/api/staticmap?size=1024x768&maptype=roadmap";
		String green = "&markers=color:green|";
		String fullURL = "";
		
		int zipcount = 0;
		
		while(fileread2.hasNextLine()){
			String line2 = fileread2.nextLine();
			String[] zipcodeLine = line2.split(",");
			if(zipcodeLine[0].equals(zip)){
				++zipcount;
			}
		}
		
		while(fileread.hasNextLine()){
			String line = fileread.nextLine();
			
			ArrayList<String> zipcodeLine = new ArrayList<String>();
			zipcodeLine.add(line);
			
			
			String x = zipcodeLine.get(0);
			String[] xy = x.split(",");
			

			if(xy[0].equals(zip)){

				fullURL = URL + green;
				
				fullURL = fullURL + xy[1] + "," + xy[2];
					
				if(zipcount>1){
					fileread.nextLine();
					for(int i = 1; i<zipcount-1;++i){
						fullURL = fullURL + xy[1] + "," + xy[2] + "|";
						fileread.nextLine();
					}
					fullURL = fullURL + xy[1] + "," + xy[2];
				}
			}
		
		}
		fullURL = fullURL + "&sensor=false";
		
		System.out.println(fullURL);
		
		GoogleMap.displayMap(fullURL, "My Route", 100, 100);
		
		fileread.close();
		fileread2.close();
		key.close();
	}

}

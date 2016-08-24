import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: October 9, 2013

*/
public class HighestGrowth {

	public static void main(String[] args) throws IOException {
		Scanner key = new Scanner(System.in);
		System.out.print("Starts with: ");
		String letter = key.next();
		int length = letter.length();
		char a = letter.charAt(0);
		
		String filename = "censusdata.csv";
		File file = new File( filename );
		Scanner fileread = new Scanner(file);
			
		fileread.nextLine();
		int lettercheck = letter.charAt(0);
		int popmax = 0;
		String countymax = "";
		if (length>2 || lettercheck<65 || lettercheck>90){
			System.out.print("Not a valid input.");
		}
		
		else {
		
		while (fileread.hasNextLine()){
				String line = fileread.nextLine();
				String[] list = line.split(",");
				String charcheck = list[0];
				
				char b = charcheck.charAt(0);
				if (a==b){
					int pop2010 = Integer.parseInt(list[1]);
					int pop2012 = Integer.parseInt(list[3]);
					int popgrowth = pop2012 - pop2010;
					
					if (popgrowth>popmax){
						popmax = popgrowth;
						countymax = list[0];
					}
				}
			}
		System.out.print("The county with the highest growth is: " + countymax + " - " + popmax);	


		}
	
		
		fileread.close();
		key.close();
	}
}



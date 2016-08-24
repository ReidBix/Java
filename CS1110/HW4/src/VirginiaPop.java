import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: October 9, 2013

*/
public class VirginiaPop {

	public static void main(String[] args) throws IOException {
		Scanner key = new Scanner(System.in);
		System.out.print("Population Max: ");
		int max = key.nextInt();
		System.out.print("Population Min: ");
		int min = key.nextInt();
		System.out.print("Year: ");
		int yr = key.nextInt();
		
		String filename = "censusdata.csv";
		File file = new File( filename );
		Scanner fileread = new Scanner(file);
		
		int yr2 = -1;
		
		fileread.nextLine();
		if (yr==2010){
			yr2 = 1;
		}
		else if (yr==2011){
			yr2 = 2;
		}
		else if (yr==2012){
			yr2 = 3;
		}
		else{
			System.out.print("Not a valid year");
		}

		if(yr2 != -1){
			while (fileread.hasNextLine()){
				String line2 = fileread.nextLine();
				String[] list = line2.split(",");
				int popcheck = Integer.parseInt(list[yr2]);

				if(popcheck<max && popcheck>min){
					System.out.println(list[0] + " - " + list[yr2]);
				}
				else if(popcheck<max && popcheck>min){
					System.out.println(list[0] + " - " + list[yr2]);
				}
				else if(popcheck<max && popcheck>min){
					System.out.println(list[0] + " - " + list[yr2]);
				}
			}
		}
		
		fileread.close();
		key.close();
	}

}

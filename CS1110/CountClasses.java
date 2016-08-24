/**
* Name: Reid Bixler, Sarah Donley
* Computing ID: rmb3yz sjd2dy@virginia.edu
* Lab Section: 1110-102
* Date: October 3, 2013
*/


import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class CountClasses {

	public static void main(String[] args) throws IOException {


		Scanner s2 = new Scanner(System.in);
		System.out.print("Give the mnemonic for a department: ");
		String dept = s2.nextLine();
		URL classes = new URL ("http://stardock.cs.virginia.edu/louslist/Courses/view/" + dept);
		Scanner s = new Scanner(classes.openStream());
		System.out.print("Give a full name of a room: ");
		String room = s2.nextLine();
		
		
		while (s.hasNextLine()){
			String line = s.nextLine();
			String[] list = line.split(";");
			String roomcheck = list[14];

			if(roomcheck.equals(room)){
				System.out.println(line);
			}
		}
		s.close();
		s2.close();
	}

}

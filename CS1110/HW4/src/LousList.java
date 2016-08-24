import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: October 9, 2013

*/


public class LousList {
	
	public static void main(String[] args) throws IOException {
		
		Scanner key = new Scanner(System.in);
		System.out.print("Course Mnemonic 1: ");
		String dept1 = key.nextLine();
		System.out.print("Course Mnemonic 2: ");
		String dept2 = key.nextLine();

		URL classes = new URL (" http://stardock.cs.virginia.edu/louslist/Courses/view/" + dept1);
		Scanner web1 = new Scanner(classes.openStream());
		
		URL classes2 = new URL (" http://stardock.cs.virginia.edu/louslist/Courses/view/" + dept2);
		Scanner web2 = new Scanner(classes2.openStream());
		
		int totstudent1 = 0;
		int totstudent2 = 0;
		
		while (web1.hasNextLine()){
			String line1 = web1.nextLine();
			String[] list1 = line1.split(";");
			int student1 = Integer.parseInt(list1[15]);
			totstudent1 += student1;
		}
		while (web2.hasNextLine()){
			String line2 = web2.nextLine();
			String[] list2 = line2.split(";");
			int student2 = Integer.parseInt(list2[15]);
			totstudent2 += student2;
		}
		System.out.println(totstudent1 + " vs. " + totstudent2);
		
		if (totstudent1>totstudent2){
			System.out.print(dept1 + " has more students!");
		}
		else if (totstudent1<totstudent2){
			System.out.print(dept2 + " has more students!");
		}
		else if (totstudent1==totstudent2){
			System.out.print(dept1 + " and " + dept2 + " have the same number of students!");
		}
		
		key.close();
		web1.close();
		web2.close();
	}
}

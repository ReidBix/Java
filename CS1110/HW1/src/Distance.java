/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 11, 2013

*/

import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the first coordinate: ");
		int firstcx = keyboard.nextInt();
		int firstcy = keyboard.nextInt();
		
		System.out.print("Enter the second coordinate: ");
		int secondcx = keyboard.nextInt();
		int secondcy = keyboard.nextInt();
		
		keyboard.close();
		
		double rise = secondcy-firstcy;
		double run =  secondcx-firstcx;
		double slope = rise/run;
		
		double sq = 2; 
		double xsq = Math.pow(secondcx-firstcx,sq);
		double ysq = Math.pow(secondcy-firstcy,sq);
		
		double length = Math.sqrt(xsq + ysq);
		
		System.out.println("Rise: " + rise);
		System.out.println("Run: " + run);
		System.out.println("Slope: " + slope);
		System.out.println("Length: " + length);
	
		

	}

}

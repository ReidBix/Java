/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 11, 2013

*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class TVSize {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("TVSize Calculator");
		System.out.println("-----------------\n");
		
		System.out.print("Diagonal length (in inches): ");
		int lengthd = keyboard.nextInt();
		
		System.out.print("Width ratio: ");
		int widthr = keyboard.nextInt();
		
		System.out.print("Height ratio: ");
		int heightr = keyboard.nextInt();
		
		double sqrt337 = Math.sqrt(337.0);
	
		double width = widthr*(lengthd/sqrt337);
		double height = heightr*(lengthd/sqrt337);
		
		DecimalFormat fmt = new DecimalFormat("0.0");
		String widthdf = fmt.format(width);
		String heightdf = fmt.format(height);
		
		System.out.println("Width: " + widthdf);
		System.out.println("Height: " + heightdf);
		
		keyboard.close();
		
	}

}

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 18, 2013

*/


import java.util.Scanner;


public class Datable {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter the first person's age: ");
		double first = s.nextDouble();
		System.out.print("Please enter the second person's age: ");
		double second = s.nextDouble();
		double ans = 0.0;
		
		
	if (first < second){
		ans = second/2 + 7;
		if(first >= ans){
		System.out.println("Dating approved!");
		}
		if(first < ans){
		System.out.println("Dating not advised...");
		}
	}
	else if (second < first){
		ans = first/2 + 7;
		if(second >= ans){
		System.out.println("Dating approved!");
		}
		if(second < ans){
		System.out.println("Dating not advised...");
		}
	}
	else if (first == second){
		System.out.println("Dating approved!");
	}
	
	s.close();
	
	}

}

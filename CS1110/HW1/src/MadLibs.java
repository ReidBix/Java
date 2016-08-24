/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 11, 2013

*/

import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("MadLibs");
		System.out.println("-------");
		
		System.out.print("Noun: ");
		String noun = new String (keyboard.nextLine());
		
		System.out.print("Noun: ");
		String noun2 = new String (keyboard.nextLine());
		
		System.out.print("Adjective: ");
		String adj = new String (keyboard.nextLine());
		
		System.out.print("Noun (a/an): ");
		String noun3 = new String (keyboard.nextLine());
		
		System.out.print("Verb (past tense): ");
		String verb = new String (keyboard.nextLine());
		
		System.out.print("Verb: ");
		String verb2 = new String (keyboard.nextLine());
		
		System.out.println("\nMary had a little " + noun);
		System.out.println("Its " + noun2 + " was " + adj + " as " + noun3);
		System.out.println("And everywhere that Mary " + verb);
		System.out.println("The " + noun + " was sure to " + verb2);
		
		keyboard.close();
		
	}

}

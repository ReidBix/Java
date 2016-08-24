/*
 *  Name: Reid Bixler and Sarah Donley
 * Computing ID: rmb3yz and sjd2dy
 * Lab Section: 1110-102 (930am)
 * Date: September 19, 2013
 *  
 */

import java.util.Random;
import java.util.Scanner;


public class Dice {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("How many times do you want to roll the pair of dice? ");
		int num = s.nextInt();
		Random randomGenerator = new Random();
		
		int r1 = randomGenerator.nextInt(6);
		r1 = r1 + 1;
		int r2 = randomGenerator.nextInt(6);
		r2 = r2 + 1;
		
		int mult1 = 0;
		int mult2 = 0;
		int mult3 = 0;
		int mult4 = 0;
		int mult5 = 0;
		int mult6 = 0;
		
		for (int i = 0; i < num; ++i){
			r1 = randomGenerator.nextInt(6);
			r1 = r1 + 1;
			r2 = randomGenerator.nextInt(6);
			r2 = r2 + 1;
			
			if (r1 == r2){
				if(r1 == 1 && r2 == 1){
					mult1 = mult1 + 1;					
				}
				else if (r1 == 2 && r2 == 2){
					mult2 = mult2 + 1;					
				}
				else if (r1 == 3 && r2 == 3){
					mult3 = mult3 + 1;					
				}
				else if (r1 == 4 && r2 == 4){
					mult4 = mult4 + 1;					
				}
				else if (r1 == 5 && r2 == 5){
					mult5 = mult5 + 1;					
				}
				else if (r1 == 6 && r2 == 6){
					mult6 = mult6 + 1;					
				}
			}	
		}
		
		System.out.println("\nYou rolled the pair of dice " + num + " times.\n");
		System.out.println("You got doubles on 1, " + mult1 + " times.");
		System.out.println("You got doubles on 2, " + mult2 + " times.");
		System.out.println("You got doubles on 3, " + mult3 + " times.");
		System.out.println("You got doubles on 4, " + mult4 + " times.");
		System.out.println("You got doubles on 5, " + mult5 + " times.");
		System.out.println("You got doubles on 6, " + mult6 + " times.");

		s.close();
		
	}

}

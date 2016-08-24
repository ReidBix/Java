/**
 * Name: Reid Bixler and Trip Burke
 * Computing ID: rmb3yz / jrb4hx
 * Lab Section: 1110-102
 * Date: September 26, 2013
 */



import java.util.Scanner;


public class Pig {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int b1 = 0;
		int b2 = 0;
		int tot1 = 0;
		int tot2 = 0;
		int roll = (int)(Math.random()*6)+1;
		
		System.out.print("How many turns would you like to play? ");
		int turns = s.nextInt();
		
		
		for (int i = 1; i<=turns; ++i){
			
		tot1 = 0;
		tot2 = 0;
		System.out.println("Player 1 Bank is " + b1);
		System.out.println("Player 2 Bank is " + b2 + "\n");
		
		//PLAYER 1
		System.out.println("Player 1 on turn number " + i + " out of " + turns + "\n");
		while (x==0){
			roll = (int)(Math.random()*6)+1;
			System.out.println("Player 1 rolled a " + roll);
			if (roll==1){
				tot1=0;
				break;
			}
			else{
				tot1 = tot1 + roll;
			}
			System.out.println("Player 1 total is " + tot1);
			do{
				System.out.print("\nDoes Player 1 want to go again? (y or n): ");
				String ans = s.next();
				if(ans.charAt(0)=='y'){
					x=0;
					y=1;
				}
				else if (ans.charAt(0)=='n'){
					x=1;
					y=1;
				}
				else {
					System.out.println("Not a valid answer.");
					y=0;
				}
			}while (y==0);
		}
		b1 = b1 + tot1;
		x = 0;
		y = 0;
		System.out.println("Player 1 Bank is " + b1 + "\n");

		
		
		System.out.println("Player 2 on turn number " + i + " out of " + turns + "\n");
		//PLAYER 2
		while (x==0){
			roll = (int)(Math.random()*6)+1;
			System.out.println("Player 2 rolled a " + roll);
			if (roll==1){
				tot2=0;
				break;
			}
			else{
				tot2 = tot2 + roll;
			}
			System.out.println("Player 2 total is " + tot2);
			do{
				System.out.print("\nDoes Player 2 want to go again? (y or n): ");
				String ans = s.next();
				if(ans.charAt(0)=='y'){
					x=0;
					y=1;
				}
				else if (ans.charAt(0)=='n'){
					x=1;
					y=1;
				}
				else {
					System.out.println("Not a valid answer.");
					y=0;
				}
			}while (y==0);
		}
		x = 0;
		y = 0;
		b2 = b2 + tot2;
		System.out.println("Player 2 Bank is " + b2 + "\n");

		}
		
		System.out.println("Player 1 Bank is " + b1);
		System.out.println("Player 2 Bank is " + b2 + "\n");
		
		if (b1>b2){System.out.println("Player 1 wins!");}
		else if (b1<b2){System.out.println("Player 2 wins!");}
		else if (b1==b2){System.out.println("Tie!");}

	
		s.close();
	}

}

import java.util.Scanner;


	public class Pig {

		public static void main(String[] args) {
			
			Scanner keyboard = new Scanner(System.in);
			int changeturn = 0;
			int repeat = 0;
			int clientbank = 0;
			int serverbank = 0;
			int clienttotal = 0;
			int servertotal = 0;
			int roll = (int)(Math.random()*6)+1;
			
			System.out.print("How many turns would you like to play? ");
			int turns = keyboard.nextInt();
			
			
			for (int i = 1; i<=turns; ++i){
				
			clienttotal = 0;
			servertotal = 0;
			System.out.println("Player 1 Bank is " + clientbank);
			System.out.println("Player 2 Bank is " + serverbank + "\n");
			
			//PLAYER 1
			System.out.println("Player 1 on turn number " + i + " out of " + turns + "\n");
			while (changeturn==0){
				roll = (int)(Math.random()*6)+1;
				System.out.println("Player 1 rolled a " + roll);
				if (roll==1){
					clienttotal=0;
					break;
				}
				else{
					clienttotal = clienttotal + roll;
				}
				System.out.println("Player 1 total is " + clienttotal);
				do{
					System.out.print("\nDoes Player 1 want to go again? (y or n): ");
					String ans = keyboard.next();
					if(ans.charAt(0)=='y' || ans.charAt(0) == 'Y'){
						changeturn=0;
						repeat=1;
					}
					else if (ans.charAt(0)=='n'|| ans.charAt(0) == 'N'){
						changeturn=1;
						repeat=1;
					}
					else {
						System.out.println("Not a valid answer.");
						repeat=0;
					}
				}while (repeat==0);
			}
			clientbank = clientbank + clienttotal;
			changeturn = 0;
			repeat = 0;
			System.out.println("Player 1 Bank is " + clientbank + "\n");

			
			
			System.out.println("Player 2 on turn number " + i + " out of " + turns + "\n");
			//PLAYER 2
			while (changeturn==0){
				roll = (int)(Math.random()*6)+1;
				System.out.println("Player 2 rolled a " + roll);
				if (roll==1){
					servertotal=0;
					break;
				}
				else{
					servertotal = servertotal + roll;
				}
				System.out.println("Player 2 total is " + servertotal);
				do{
					System.out.print("\nDoes Player 2 want to go again? (y or n): ");
					String ans = keyboard.next();
					if(ans.charAt(0)=='y' || ans.charAt(0) == 'Y'){
						changeturn=0;
						repeat=1;
					}
					else if (ans.charAt(0)=='n'|| ans.charAt(0) == 'N'){
						changeturn=1;
						repeat=1;
					}
					else {
						System.out.println("Not a valid answer.");
						repeat=0;
					}
				}while (repeat==0);
			}
			changeturn = 0;
			repeat = 0;
			serverbank = serverbank + servertotal;
			System.out.println("Player 2 Bank is " + serverbank + "\n");

			}
			
			System.out.println("Player 1 Bank is " + clientbank);
			System.out.println("Player 2 Bank is " + serverbank + "\n");
			
			if (clientbank>serverbank){System.out.println("Player 1 wins!");}
			else if (clientbank<serverbank){System.out.println("Player 2 wins!");}
			else if (clientbank==serverbank){System.out.println("Tie!");}

		
			keyboard.close();
		}

	}

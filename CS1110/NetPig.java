import java.util.Random;
import java.util.Scanner;

public class NetPig {

	private SocketScanner netscanner;
	private Scanner keyboard = new Scanner(System.in);
	private boolean gameover = false;
	
	// Allocate other variables you may need in the class here!

	public static void main(String[] args) {
		NetPig myPigGame = new NetPig();

	}

	public NetPig() {
		System.out.println("NetPig!");
		System.out.print("Do you want to host the game? (y/n): ");
		char hostChoice = keyboard.nextLine().charAt(0);

		if (hostChoice == 'y' || hostChoice == 'Y') {
			startGameAsServer();
		} else {
			startGameAsClient();
			takeTurn();
		}

		while (!gameover) {
			waitForTurn();
			takeTurn();
			
		}
		
		
	}

	public void startGameAsServer() {
		// Put code here for the server to get going!
	}

	public void startGameAsClient() {
		// Put code here for the client to get going!
	}

	public void waitForTurn() {
		// Put code here to listen to what's coming over the netscanner
		// and print the output to the screen until "Your turn!" or 
		// "Your opponent won" is passed. 
	}

	public void takeTurn() {
		if (gameover) return;
		// Put the logic for taking a turn here.
		// Make sure to add output lines to print what is going on
		// to the netscanner!
	}
	
	// A pig for you to use :-)
	public void printPig() {
				System.out.println("        ,.");
				System.out.println("        (_|,.");
				System.out.println("       ,' /, )_______   _");
				System.out.println("    __j o``-'        `.'-)'");
				System.out.println("   (\")                 \'");
				System.out.println("    `-j                |");
				System.out.println("      `-._(           /");
				System.out.println("         |_\\  |--^.  /");
				System.out.println("        /_]'|_| /_)_/");
				System.out.println("           /_]'  /_]'");
	}

}

import java.util.Scanner;

public class NetPigTake2 {
	private SocketScanner netscanner;
	private Scanner keyboard = new Scanner(System.in);
	private boolean gameover = false;
	private int clientbank = 0;
	private int serverbank = 0;
	private boolean clientcheck = true;
	private boolean servercheck = true;
	private boolean gamestart = true;
	private boolean changeturn = false;
	private int finalScore = 100;

	public static void main(String[] args) {
		NetPigTake2 myPigGame = new NetPigTake2();

	}

	public NetPigTake2() {
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
		gamestart = true;
		clientcheck = false;
		servercheck = true;

		netscanner = SocketScanner.createAsTheHost();
	}

	public void startGameAsClient() {
		gamestart = true;
		clientcheck = true;
		servercheck = false;

		System.out.print("What ip address? ");
		String ip = keyboard.next();
		System.out.print("What port? ");
		int port = keyboard.nextInt();
		netscanner = SocketScanner.connectToHost(ip, port);
	}

	public void waitForTurn() {

		if (gamestart == true) {
			System.out.println("Guest goes first!");
			System.out.println("First player to " + finalScore + " wins!\n");

			gamestart = false;
		}

		System.out.println("\n---------------------");
		System.out.println("It's your opponent's turn!");
		System.out.println("---------------------");

		while (changeturn == false) {
			String string = netscanner.nextLine();

			String incoming = "INCOMING BANK!";
			if (string.equals(incoming)) {

				if (clientcheck == false) {
					clientbank = Integer.parseInt(netscanner.nextLine());
				} else if (servercheck == false) {
					serverbank = Integer.parseInt(netscanner.nextLine());
				}

				string = netscanner.nextLine();
			}

			System.out.println(string);

			String s = "Your opponent won... sorry!";
			if (string.equals(s)) {
				gameover = true;

			}

			if (gameover == false) {

				String yourturn = "Your turn!";
				if (string.equals(yourturn)) {
					changeturn = true;
				}

			}

			if (gameover == true) {
				System.exit(0);
			}

		}

	}

	public void takeTurn() {
		if (gameover)
			return;

		if (gamestart == true) {
			System.out.println("Connection succeeded!");
			System.out.println("Guest goes first!");
			System.out.println("First player to " + finalScore + " wins!");
			gamestart = false;
		}

		System.out.println("\n---------------------");
		System.out.println("It's your turn!");
		System.out.println("---------------------");

		boolean repeat = true;
		int roll = 0;
		int total = 0;
		int beforetotal = 0;

		changeturn = false;

		if (clientcheck == true) {
			System.out.println("You currently have " + clientbank + " points");
			netscanner.println("Your opponent currently has " + clientbank
					+ " points");
		}

		else if (servercheck == true) {
			System.out.println("You currently have " + serverbank + " points");
			netscanner.println("Your opponent currently has " + serverbank
					+ " points");
		}

		while (changeturn == false) {

			System.out.println("\nRolling the die...");
			netscanner.println("\nRolling the die...");

			roll = (int) (Math.random() * 6) + 1;

			if (roll != 0) {
				System.out.println("You rolled a " + roll + "!");
				netscanner.println("Your opponent rolled a " + roll + ".");
			}

			if (roll == 1) {
				printPig();
				System.out.println("Your turn is over! You lost " + total
						+ " points!");
				netscanner.println("PIG! Your opponent lost " + total
						+ " points!");
				total = 0;
				break;
			}

			else {
				beforetotal = total;
				total = total + roll;

				System.out.println("Adding " + roll + " to your temp total : "
						+ beforetotal + " -> " + total);
				netscanner.println("Adding " + roll + " to the temp total : "
						+ beforetotal + " -> " + total);

			}

			do {
				System.out.print("Do you wish to continue? (y or n): ");
				String ans = keyboard.next();

				if (ans.charAt(0) == 'y' || ans.charAt(0) == 'Y') {
					changeturn = false;
					repeat = false;

				}

				else if (ans.charAt(0) == 'n' || ans.charAt(0) == 'N') {
					changeturn = true;
					repeat = false;

					if (clientcheck == true) {

						System.out.println("You are banking " + total
								+ " points: " + clientbank + " -> "
								+ (clientbank + total));
						netscanner.println("Your opponent has banked " + total
								+ " points: " + clientbank + " -> "
								+ (clientbank + total));

						clientbank = clientbank + total;

						String bankstring = "" + clientbank;
						netscanner.println("INCOMING BANK!");
						netscanner.println(bankstring);

					} else if (servercheck == true) {

						System.out.println("You are banking " + total
								+ " points: " + serverbank + " -> "
								+ (total + serverbank));
						netscanner.println("Your opponent has banked " + total
								+ " points: " + serverbank + " -> "
								+ (total + serverbank));

						serverbank = serverbank + total;

						String bankstring = "" + serverbank;
						netscanner.println("INCOMING BANK!");
						netscanner.println(bankstring);

					}
				} else {
					System.out.println("Not a valid answer.");
					repeat = true;
				}
			} while (repeat == true);

		}

		if (clientcheck == true) {

			System.out.println("You currently have " + clientbank
					+ " points banked.");
			netscanner.println("Your opponent currently has " + clientbank
					+ " points banked.");

			if (clientbank >= finalScore) {
				System.out.println("YOU WIN!");
				netscanner.println("Your opponent won... sorry!");
				gameover = true;
			}

		} else if (servercheck == true) {
			System.out.println("You currently have " + serverbank
					+ " points banked.");
			netscanner.println("Your opponent currently has " + serverbank
					+ " points banked.");
			if (serverbank >= finalScore) {
				System.out.println("YOU WIN!");
				netscanner.println("Your opponent won... sorry!");
				gameover = true;
			}

		}

		changeturn = false;
		netscanner.println("Your turn!");

	}

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

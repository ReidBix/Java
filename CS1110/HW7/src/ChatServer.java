import java.util.Scanner;


public class ChatServer {
	private SocketScanner netscanner;
	private int port = 40000;
	private String ip = null;
	private Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.startChat();
		
	}
	
	public ChatServer() {
		//Setup your SocketScanner here
		netscanner = SocketScanner.createAsTheHost();
		
		netscanner.println("Hello peoples");
		
		//if (keyboard.hasNextLine()){
			
		//}
		
		
	}
	
	public void startChat() {
		//The server should wait for a message first, then respond.  The program should end when "quit" is typed.
		/*while (netscanner.hasNextLine()){
			System.out.println(netscanner.nextLine());
		}
		*/
		
		System.out.println(netscanner.nextLine());
		
		int x = 0;
		
		while (x == 0){

			String hello = keyboard.nextLine();
			netscanner.println(hello);
			
			String quit = "quit";
			if (netscanner.nextLine().equals(quit)){
				System.exit(0);
			}
			System.out.println(netscanner.nextLine());
			
		}
		
	}


}

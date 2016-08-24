import java.util.Scanner;


public class ChatClient {
	private SocketScanner netscanner;
	private int port = 40000;
	private String ip = null;
	private Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.startChat();
		
		
	}
	
	public ChatClient() {
		//Setup your SocketScanner here after asking the user for an ip and port
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What ip address? ");
		String ip = keyboard.next();
		System.out.print("What port? ");
		int port = keyboard.nextInt();
		
		netscanner = SocketScanner.connectToHost(ip, port);
		
		System.out.println(netscanner.nextLine());
		
		//if (netscanner.hasNextLine()){
		//}

		//if (netscanner.hasNextLine()){
		
		//}
	}
	
	public void startChat() {
		//The client should send a message first, then wait for a response.  The program should end when "quit" is typed.
		
		//String sentence = keyboard.nextLine();
		//netscanner.println(sentence);
		int x = 0;
		
		while (x == 0){
			String hello = keyboard.nextLine();
			String quit = "quit";
			if (hello.equals(quit)){
				netscanner.println(hello);
				System.exit(0);
			}
			else {
				netscanner.println(hello);
				System.out.println(netscanner.nextLine());
			}
		}
			
	}

}

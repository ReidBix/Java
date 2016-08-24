import java.util.Scanner;


public class ExampleClient {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What ip address? ");
		String ip = keyboard.next();
		System.out.print("What port? ");
		int port = keyboard.nextInt();
		
		SocketScanner ss = SocketScanner.connectToHost(ip, port);
		
		System.out.println(ss.nextLine());
		
	}

}

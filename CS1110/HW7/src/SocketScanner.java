/**
 * Names: Reid Bixler, Camille Hochheimer
 * Computing IDs: rmb3yz, cjh8uc
 * Lab Section: 1110-102
 * Date: December 4, 2013
 */



import java.io.IOException;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class SocketScanner {
	private Socket s;
	private String name;
	private boolean debug;

	/**
	 * Will cause future println and nextLine invocations
	 * to print out messages about what they are doing
	 */
	public void enableDebugMessages() { this.debug = true; }

	/**
	 * Will cause future println and nextLine invocations
	 * to run silently, not printing out what theyt are doing
	 */
	public void disableDebugMessages() { this.debug = false; }

	/**
	 * Creates a scanner-like wrapper around a socket. Debugging is enabled.
	 * @param s The socket to use
	 * @param name The name of this scanner (for use in debugging messages)
	 */
	public SocketScanner(Socket s, String name) {
		this(s, name, true);
	}
	
	/**
	 * Creates a scanner-like wrapper around a socket. Debugging is disabled
	 * and the name is set to "SocketScanner".
	 * @param s The socket to use
	 */
	public SocketScanner(Socket s) {
		this(s, "SocketScanner", false);
	}
	
	/**
	 * Creates a scanner-like wrapper around a socket.
	 * @param s The socket to use
	 * @param name The name of this scanner (for use in debugging messages)
	 * @param debug false means don't print debugging messages
	 */
	public SocketScanner(Socket s, String name, boolean debug) {
		this.s = s;
		this.name = name;
		this.debug = debug;
	}
	
	/**
	 * Sends a line of text across the socket.
	 * @param line The text to send
	 */
	public void println(String line) {
		//line = line.replaceAll("\\s+", " ");
		if (debug);// System.out.println("\t("+name+ " sending \""+line+"\"...)");
		try {
			s.getOutputStream().write(line.getBytes());
			s.getOutputStream().write('\n');
			s.getOutputStream().flush();
			if (debug);// System.out.println("\t("+name+ " sent line successfully)");
		} catch (IOException e) {
			System.err.println("Send failed (other end may have closed?)");
		}
	}
	
	/**
	 * @param secondsToWait how long to wait to see if there is more input
	 * @return true if something is available before it is done waiting
	 */
	public boolean hasNextLine(double secondsToWait) {
		try {
			if (s.getInputStream().available() > 0) return true;
			for(double t=0; t < secondsToWait; t += 0.125) {
				try { Thread.sleep(125); } catch (InterruptedException e) { }
				if (s.getInputStream().available() > 0) return true;
			}
			return false;
		} catch (IOException e) { return false; }
	}
	
	/**
	 * Will wait up to a second for more input
	 * @return true if something is available before it is done waiting
	 */
	public boolean hasNextLine() {
		return this.hasNextLine(1.0);
	}

	/**
	 * Reads a line of text from the socket. 
	 * Will wait as long as needed for a line to appear.
	 * @return the line of text read
	 */
	public String nextLine() {
		if (debug);// System.out.println("\t("+name+ " waiting for a line of text...)");
		try {
			StringBuilder sb = new StringBuilder();
			int c = s.getInputStream().read();
			while (c != '\n' && c >= 0) {
				sb.append((char)c);
				c = s.getInputStream().read();
			}
			if (debug);// System.out.println("\t("+name+" recieved \""+sb.toString()+"\")");
			return sb.toString();
		} catch (IOException e) {
			System.err.println("Receiving failed (other end may have closed?)");
			throw new RuntimeException(e);
		}
	}
	
	
	public static String myIPAddresses() {
		String best = "";
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				NetworkInterface n = nis.nextElement();
				for(InterfaceAddress ia : n.getInterfaceAddresses()) {
					String option = ia.getAddress().getHostAddress();
					if (option.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+")) {
						if (!option.startsWith("127.0.0")) {
							if (best.length() > 0) best += " or "+option;
							else best = option; 
						}
					}
				}
			}
		} catch (SocketException e) {}
		if (best.length() == 0) best = "localhost";
		return best;
	}

	
	public static SocketScanner createAsTheHost() {
		try {
			ServerSocket ss = new ServerSocket(0);
			int p = ss.getLocalPort();
			System.out.println("Host listening with IP "+myIPAddresses()+" and port "+p);
			return new SocketScanner(ss.accept(), "host");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static SocketScanner connectToHost(String ip, int port) {
		try {
			return new SocketScanner(new Socket(ip, port), "client");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
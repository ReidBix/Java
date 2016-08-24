
public class ExampleHost {

	public static void main(String[] args) {
		SocketScanner ss = SocketScanner.createAsTheHost();
		ss.println("Hi, I am the host");
	}

}

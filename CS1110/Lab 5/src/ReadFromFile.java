import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ReadFromFile {

	public static void main(String[] args) throws IOException {
		// file name
		String fileName = "J:\\Class\\1110-F13\\eclipse\\2013-09-23\\src\\ReadFromFile.java";
		// file object
		File myFile = new File( fileName );
		// open
		Scanner myFileReader = new Scanner( myFile ); // scanner opens it for me
		// read with scanner
		while (myFileReader.hasNextLine()) {
			String line = myFileReader.nextLine();
			// (do stuff)
			System.out.println(line);
		}
		System.out.println("Done reading from file.");
		// close
		myFileReader.close();
	}

}

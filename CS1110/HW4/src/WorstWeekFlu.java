import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: October 9, 2013

*/



public class WorstWeekFlu {

	public static void main(String[] args) throws IOException {

		Scanner key = new Scanner(System.in);
		System.out.print("State: ");
		String state = key.nextLine();
		
		String filename = "fludata.csv";
		File file = new File( filename );
		Scanner fileread = new Scanner(file);
		
		int statenum = 0;
		int maxflu = 0;
		String fludate = "";
		String line1 = fileread.nextLine();

		for (int i = 0; i<51;++i){
			String[] list1 = line1.split(",");

			String statecheck = list1[i];

			if (state.equals(statecheck)){
				statenum = i;
				break;
			}
		}
		if (statenum == 0){
			System.out.print("State not found.");
		}
		else {
		while (fileread.hasNextLine()){
			String line2 = fileread.nextLine();
			String[] list2 = line2.split(",");
			int numflu = Integer.parseInt(list2[statenum]);
			if(numflu>maxflu){
				maxflu = numflu;
				fludate = list2[0];
			}
		}
		System.out.print("Worst week for " + state + ": " + fludate + " - " + maxflu + " instances");
		}
		fileread.close();
		key.close();
	}

}

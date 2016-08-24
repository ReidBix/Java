import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: October 9, 2013

*/

public class WorstStateFlu {

	public static void main(String[] args) throws IOException {
		Scanner key = new Scanner(System.in);
		System.out.print("First State: ");
		String state = key.nextLine();
		
		System.out.print("Second State: ");
		String state2 = key.nextLine();
		
		String filename = "fludata.csv";
		File file = new File( filename );
		Scanner fileread = new Scanner(file);
		
		String filename2 = "fludata.csv";
		File file2 = new File( filename2 );
		Scanner fileread2 = new Scanner(file2);
		
		int statenum = 0;
		int statenum2 = 0;
		int sumflu = 0;
		int sumflu2 = 0;
		
		String line1 = fileread.nextLine();
		fileread2.nextLine();

		for (int i = 0; i<51;++i){
			String[] list1 = line1.split(",");

			String statecheck = list1[i];

			if (state.equals(statecheck)){
				statenum = i;
				break;
			}
		}
		for (int i = 0; i<51;++i){
			String[] list1 = line1.split(",");

			String statecheck2 = list1[i];

			if (state2.equals(statecheck2)){
				statenum2 = i;
				break;
			}
		}
		if (statenum == 0 || statenum2 == 0){
			System.out.print("State not found.");
		}
		
		else {
		while (fileread.hasNextLine()){
			String line2 = fileread.nextLine();
			String[] list2 = line2.split(",");
			int numflu = Integer.parseInt(list2[statenum]);
			sumflu += numflu;
			}
		while (fileread2.hasNextLine()){
			String line2 = fileread2.nextLine();
			String[] list2 = line2.split(",");
			int numflu2 = Integer.parseInt(list2[statenum2]);
			sumflu2 += numflu2;
			}
		}
		if (sumflu>sumflu2){
		System.out.print(state + " was worse than " + state2 + " - " + sumflu + " vs. " + sumflu2);
		}
		else if (sumflu<sumflu2){
		System.out.print(state2 + " was worse than " + state + " - " + sumflu2 + " vs. " + sumflu);
		}
		else if (sumflu==sumflu2){
		System.out.print(state + " and " + state2 + " are equally bad! - " + sumflu);
		}
		fileread.close();
		fileread2.close();
		key.close();
	}

}

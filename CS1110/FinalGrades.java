/**
* Name: Reid Bixler, Sarah Donley
* Computing ID: rmb3yz sjd2dy@virginia.edu
* Lab Section: 1110-102
* Date: October 3, 2013
*/

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class FinalGrades {

	public static void main(String[] args) throws IOException {
		URL grades = new URL ("http://stardock.cs.virginia.edu/cs1110/grades.csv");
		Scanner s = new Scanner(grades.openStream());
		double HW = 0;
		double HWadd = 0;
		double HWgrade = 0;
		double lab = 0;
		double labgrade = 0;
		double test = 0;
		double testadd = 0;
		double testgrade = 0;
		double fexam = 0;
		double fexamgrade = 0;
		double Final = 0;
		String lettergrade = "";
		s.nextLine();
		
		while (s.hasNextLine()){
			HW = 0;
			HWadd = 0;
			HWgrade = 0;
			lab = 0;
			labgrade = 0;
			test = 0;
			testadd = 0;
			testgrade = 0;
			fexam = 0;
			fexamgrade = 0;
			Final = 0;
			lettergrade = "";
		
		String line = s.nextLine();
			for (int i = 0; i<7;++i){
			String[] student = line.split(",");
			HWadd = Double.parseDouble(student[1+i]);
			HW = HW + HWadd;
		}
		HWgrade = HW/105;
		HWgrade = HWgrade*.35;
		
			for (int i = 0; i<1;++i){
				String[] student = line.split(",");
				lab = Double.parseDouble(student[8]);
			}
		labgrade = lab/15;
		labgrade = labgrade*.15;
		
			for (int i = 0; i<2;++i){
				String[] student = line.split(",");
				testadd = Double.parseDouble(student[9+i]);
				test = test + testadd;
			}
		testgrade = test/200;
		testgrade = testgrade*.3;
		
			for (int i = 0; i<1;++i){
				String[] student = line.split(",");
				fexam = Double.parseDouble(student[11]);
			}
		fexamgrade = fexam/100;
		fexamgrade = fexamgrade*.2;
		
		Final = HWgrade + labgrade + testgrade + fexamgrade;
		Final = Final*100;
		
		if (Final>=98.000){
			lettergrade = "A+";
		}
		else if (Final>=93.000){
			lettergrade = "A";
		}
		else if (Final>=90.000){
			lettergrade = "A-";
		}
		else if (Final>=87.000){
			lettergrade = "B+";
		}
		else if (Final>=83.000){
			lettergrade = "B";
		}
		else if (Final>=80.000){
			lettergrade = "B-";
		}
		else if (Final>=77.000){
			lettergrade = "C+";
		}
		else if (Final>=73.000){
			lettergrade = "C";
		}
		else if (Final>=70.000){
			lettergrade = "C-";
		}
		else if (Final>=67.000){
			lettergrade = "D+";
		}
		else if (Final>=63.000){
			lettergrade = "D";
		}
		else if (Final>=60.000){
			lettergrade = "D-";
		}
		else if (Final>=0.000){
			lettergrade = "F";
		}		
		String[] student = line.split(",");
		System.out.println(student[0] + ": " + Final + " / " + lettergrade);

		
		}
		
		s.close();
	}

}

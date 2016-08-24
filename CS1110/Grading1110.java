/**
* Name: Reid Bixler, Sarah Donley
* Computing ID: rmb3yz sjd2dy@virginia.edu
* Lab Section: 1110-102
* Date: October 3, 2013
*/

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Grading1110 {

	public static void main(String[] args) throws IOException {

		URL grades = new URL ("http://stardock.cs.virginia.edu/cs1110/grades.csv");
		Scanner s = new Scanner(grades.openStream());
		double finalExam = 0;
		int count = 0;
		double grade = 0;
		s.nextLine();
		while(s.hasNextLine()){
			String line = s.nextLine();
			String[] student = line.split(",");
			finalExam = Double.parseDouble(student[11]);
			++count;
			grade = finalExam +grade;	
			
		}
		grade = grade/count;
		System.out.println("The average of the final exams is " + grade);
		
		s.close();
	}

}

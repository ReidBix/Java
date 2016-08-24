import java.util.Scanner;


public class Sundays {
	
	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the end year: ");
		int yr = s.nextInt();
		int count = 0;
		int first = 3;
		// 31 = Jan, Mar, May, Jul, Aug, Oct, Dec
		// 30 = Apr, Jun, Sep, Nov
		// 28 = Feb Leap Year then 29 = Feb 
		// Jan to Feb + 3
		// Feb to Mar + 0 unless Leap then Feb to Mar + 1
		// Mar to Apr + 3
		// Apr to May + 2
		
		// May to Jun + 3
		// Jun to Jul + 2
		// Jul to Aug + 3
		// Aug to Sep + 3
		
		// Sep to Oct + 2
		// Oct to Nov + 3
		// Nov to Dec + 2
		// Dec to Jan + 3
		
		// Jan1 1901 = Tu or 3
		// Feb1 1901 = Fr or 6
		// Mar1 1901 = Fr or 6
		// Apr1 1901 = 9-7 = 2 Mon
		//Jan 1901 = 3
		
		for (int i=1901; i<=yr; ++i){
			if (i%4 != 0 && i%400 != 0){
				//Non-Leap
				//Jan
				first = first%7;
				if (first == 1){System.out.println("Jan 1, " + i);++count;}
				//Feb
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Feb 1, " + i);++count;}
				//Mar
				first = first + 0;first = first%7;
				if (first == 1){System.out.println("Mar 1, " + i);++count;}
				//Apr
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Apr 1, " + i);++count;}
				//May
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("May 1, " + i);++count;}
				//Jun
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Jun 1, " + i);++count;}
				//Jul
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("Jul 1, " + i);++count;}
				//Aug
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Aug 1, " + i);++count;}
				//Sep
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Sep 1, " + i);++count;}
				//Oct
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("Oct 1, " + i);++count;}
				//Nov
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Nov 1, " + i);++count;}
				//Dec
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("Dec 1, " + i);++count;}
				//Jan
				first = first + 3;first = first%7;
				}
			if (i%4 == 0 || i%400 == 0){
				//Leap
				//Jan
				first = first%7;
				if (first == 1){System.out.println("Jan 1, " + i);++count;}
				//Feb
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Feb 1, " + i);++count;}
				//Mar
				first = first + 1;first = first%7;
				if (first == 1){System.out.println("Mar 1, " + i);++count;}
				//Apr
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Apr 1, " + i);++count;}
				//May
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("May 1, " + i);++count;}
				//Jun
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Jun 1, " + i);++count;}
				//Jul
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("Jul 1, " + i);++count;}
				//Aug
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Aug 1, " + i);++count;}
				//Sep
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Sep 1, " + i);++count;}
				//Oct
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("Oct 1, " + i);++count;}
				//Nov
				first = first + 3;first = first%7;
				if (first == 1){System.out.println("Nov 1, " + i);++count;}
				//Dec
				first = first + 2;first = first%7;
				if (first == 1){System.out.println("Dec 1, " + i);++count;}
				//Jan
				first = first + 3;first = first%7;
			}	
		}
		System.out.print("Number of Sundays: " + count);
		s.close();
		
	}
}

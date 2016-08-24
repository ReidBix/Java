/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 18, 2013

*/


import java.util.Scanner;


public class Roman {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter an integer greater than 0 and less than 4000: ");
		String num = s.nextLine();
		int numlength = num.length();
		
		//NUMBERS LESS THAN 10
		if (numlength == 1){
			char a = num.charAt(0);
			String d1 = "a";
			
			switch (a){
			case 48:
				d1 = "Not a valid entry!";
				break;
			case 49:
				d1 = "I";
				break;
			case 50:
				d1 = "II";
				break;
			case 51:
				d1 = "III";
				break;
			case 52:
				d1 = "IV";
				break;
			case 53:
				d1 = "V";
				break;
			case 54:
				d1 = "VI";
				break;
			case 55:
				d1 = "VII";
				break;
			case 56:
				d1 = "VIII";
				break;
			case 57:
				d1 = "IX";
				break;
			}
			System.out.print(d1);
			
		}
		
		
		
		
		//NUMBERS LESS THAN 100
		else if (numlength == 2 ){
			
			//TENS DIGIT
			char a = num.charAt(0);
			String d1 = "a";
		
			switch (a){
			case 49:
				d1 = "X";
				break;
			case 50:
				d1 = "XX";
				break;
			case 51:
				d1 = "XXX";
				break;
			case 52:
				d1 = "XL";
				break;
			case 53:
				d1 = "L";
				break;
			case 54:
				d1 = "LX";
				break;
			case 55:
				d1 = "LXX";
				break;
			case 56:
				d1 = "LXXX";
				break;
			case 57:
				d1 = "XC";
				break;
			}
			
			
			//ONES DIGIT
			char b = num.charAt(1);
			String d2 = "a";
			
			switch (b){
			case 48:
				d2 = "";
				break;
			case 49:
				d2 = "I";
				break;
			case 50:
				d2 = "II";
				break;
			case 51:
				d2 = "III";
				break;
			case 52:
				d2 = "IV";
				break;
			case 53:
				d2 = "V";
				break;
			case 54:
				d2 = "VI";
				break;
			case 55:
				d2 = "VII";
				break;
			case 56:
				d2 = "VIII";
				break;
			case 57:
				d2 = "IX";
				break;
			}
			System.out.print(d1+d2);
	}

		
		
	//NUMBERS LESS THAN 1000	
		
		
		else if (numlength == 3){
		
		//HUNDREDS DIGIT
				char a = num.charAt(0);
				String d1 = "a";
			
				switch (a){
				case 49:
					d1 = "C";
					break;
				case 50:
					d1 = "CC";
					break;
				case 51:
					d1 = "CCC";
					break;
				case 52:
					d1 = "CD";
					break;
				case 53:
					d1 = "D";
					break;
				case 54:
					d1 = "DC";
					break;
				case 55:
					d1 = "DCC";
					break;
				case 56:
					d1 = "DCCC";
					break;
				case 57:
					d1 = "CM";
					break;
				}
						
		
		//TENS DIGIT
		char b = num.charAt(1);
		String d2 = "a";
	
		switch (b){
		case 48:
			d2 = "";
			break;
		case 49:
			d2 = "X";
			break;
		case 50:
			d2 = "XX";
			break;
		case 51:
			d2 = "XXX";
			break;
		case 52:
			d2 = "XL";
			break;
		case 53:
			d2 = "L";
			break;
		case 54:
			d2 = "LX";
			break;
		case 55:
			d2 = "LXX";
			break;
		case 56:
			d2 = "LXXX";
			break;
		case 57:
			d2 = "XC";
			break;
		}
		
		
		//ONES DIGIT
		char c = num.charAt(2);
		String d3 = "a";
		
		switch (c){
		case 48:
			d3 = "";
			break;
		case 49:
			d3 = "I";
			break;
		case 50:
			d3 = "II";
			break;
		case 51:
			d3 = "III";
			break;
		case 52:
			d3 = "IV";
			break;
		case 53:
			d3 = "V";
			break;
		case 54:
			d3 = "VI";
			break;
		case 55:
			d3 = "VII";
			break;
		case 56:
			d3 = "VIII";
			break;
		case 57:
			d3 = "IX";
			break;
		}
		System.out.print(d1+d2+d3);
		
		
	}
	
	
	
	//NUMBERS LESS THAN 4000
		else if (numlength == 4){
	
			
	//THOUSANDS DIGIT
	char a = num.charAt(0);
	String d1 = "a";

	if (a>=52){
		System.out.println("Not a valid entry!");
	}
	
	else if (a>48 && a<52){
	switch (a){
	case 49:
		d1 = "M";
		break;
	case 50:
		d1 = "MM";
		break;
	case 51:
		d1 = "MMM";
		break;
	}
			
	
	
		//HUNDREDS DIGIT
				char b = num.charAt(1);
				String d2 = "a";
			
				switch (b){
				case 48:
					d2 = "";
					break;
				case 49:
					d2 = "C";
					break;
				case 50:
					d2 = "CC";
					break;
				case 51:
					d2 = "CCC";
					break;
				case 52:
					d2 = "CD";
					break;
				case 53:
					d2 = "D";
					break;
				case 54:
					d2 = "DC";
					break;
				case 55:
					d2 = "DCC";
					break;
				case 56:
					d2 = "DCCC";
					break;
				case 57:
					d2 = "CM";
					break;
				}
						
		
		//TENS DIGIT
		char c = num.charAt(2);
		String d3 = "a";
	
		switch (c){
		case 48:
			d3 = "";
			break;
		case 49:
			d3 = "X";
			break;
		case 50:
			d3 = "XX";
			break;
		case 51:
			d3 = "XXX";
			break;
		case 52:
			d3 = "XL";
			break;
		case 53:
			d3 = "L";
			break;
		case 54:
			d3 = "LX";
			break;
		case 55:
			d3 = "LXX";
			break;
		case 56:
			d3 = "LXXX";
			break;
		case 57:
			d3 = "XC";
			break;
		}
		
		
		//ONES DIGIT
		char d = num.charAt(3);
		String d4 = "a";
		
		switch (d){
		case 48:
			d4 = "";
			break;
		case 49:
			d4 = "I";
			break;
		case 50:
			d4 = "II";
			break;
		case 51:
			d4 = "III";
			break;
		case 52:
			d4 = "IV";
			break;
		case 53:
			d4 = "V";
			break;
		case 54:
			d4 = "VI";
			break;
		case 55:
			d4 = "VII";
			break;
		case 56:
			d4 = "VIII";
			break;
		case 57:
			d4 = "IX";
			break;
		}
		System.out.print(d1+d2+d3+d4);
		
		
	}
		}
		
		else if (numlength > 4 || numlength < 1 ){
			System.out.println("Not a valid entry!");
		}
		
		
		s.close();
}
}
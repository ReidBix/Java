import java.util.Scanner;


public class CreditCardCheck {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Please enter a credit card number with no spaces: ");
		String c = s.nextLine();
		int length = c.length();
		int a2 = 0;
		int a4 = 0;
		int a5 = 0;
		int a6 = 0;
		int a7 = 1;
		int a8 = 0;
		int a9 = 0;
		int a10 = 0;
		for (int i = 1; i<=length; i += 2){
		
		int a = c.charAt(length-i);
		a = a-48;
		a2 = a2 + a;
		
			if (length-i-1>=0){
			int a3 = c.charAt(length-i-1);
			a3 = a3-48;
			a3 = a3*2;
	
			switch (a3){
			case 0:
				a5 = 0;
				a3 = 0;
				a4 = a4 + a3 + a5;
				break;
			case 2:
				a5 = 0;
				a3 = 2;
				a4 = a4 + a3 + a5;
				break;
			case 4:
				a5 = 0;
				a3 = 4;
				a4 = a4 + a3 + a5;
				break;
			case 6:
				a5 = 0;
				a3 = 6;
				a4 = a4 + a3 + a5;
				break;
			case 8:
				a5 = 0;
				a3 = 8;
				a4 = a4 + a3 + a5;
				break;
			case 10:
				a5 = 1;
				a3 = 0;
				a4 = a4 + a3 + a5;
				break;
			case 12:
				a5 = 1;
				a3 = 2;
				a4 = a4 + a3 + a5;
				break;
			case 14:
				a5 = 1;
				a3 = 4;
				a4 = a4 + a3 + a5;
				break;
			case 16:
				a5 = 1;
				a3 = 6;
				a4 = a4 + a3 + a5;
				break;
			case 18:
				a5 = 1;
				a3 = 8;
				a4 = a4 + a3 + a5;
				break;
			case 20:
				a5 = 2;
				a3 = 0;
				a4 = a4 + a3 + a5;
				break;
			}
			}
		}
		a6 = a2 + a4;
		a7 = a6%10;
		
		a8 = c.charAt(length-1);
		a8 = a8 - 48;
		a9 = 10 - a7;
		a10 = a8 + a9;
		
		if (a7 == 0){
			System.out.print("Valid Credit Card!");
		}
		else if (a7 != 0){
			System.out.println("Invalid Credit Card!");
			System.out.print("The check digit should be: " + a10);
		}
		s.close();
	}

}

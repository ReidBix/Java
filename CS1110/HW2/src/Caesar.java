/**
 * Name: Reid Bixler
 * Computing ID: rmb3yz
 * Lab Section: 1110-102
 * Date: September 18, 2013

 */

import java.util.Scanner;

public class Caesar {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Please give me the ciphertext: ");
		String c = s.nextLine();
		String c2 = c.toUpperCase();
		char a = 0;

		System.out.print("The decoded phrase is: ");
		int l = c2.length();

		for (int i = 0; i < l; ++i) {
			a = c2.charAt(0 + i);

		

			switch (a) {

			case 65:
				a = 88;
				System.out.print(a);
				break;
			case 66:
				a = 89;
				System.out.print(a);
				break;
			case 67:
				a = 90;
				System.out.print(a);
				break;
			case 68:
				a = 65;
				System.out.print(a);
				break;
			case 69:
				a = 66;
				System.out.print(a);
				break;
			case 70:
				a = 67;
				System.out.print(a);
				break;
			case 71:
				a = 68;
				System.out.print(a);
				break;
			case 72:
				a = 69;
				System.out.print(a);
				break;
			case 73:
				a = 70;
				System.out.print(a);
				break;
			case 74:
				a = 71;
				System.out.print(a);
				break;
			case 75:
				a = 72;
				System.out.print(a);
				break;
			case 76:
				a = 73;
				System.out.print(a);
				break;
			case 77:
				a = 74;
				System.out.print(a);
				break;
			case 78:
				a = 75;
				System.out.print(a);
				break;
			case 79:
				a = 76;
				System.out.print(a);
				break;
			case 80:
				a = 77;
				System.out.print(a);
				break;
			case 81:
				a = 78;
				System.out.print(a);
				break;
			case 82:
				a = 79;
				System.out.print(a);
				break;
			case 83:
				a = 80;
				System.out.print(a);
				break;
			case 84:
				a = 81;
				System.out.print(a);
				break;
			case 85:
				a = 82;
				System.out.print(a);
				break;
			case 86:
				a = 83;
				System.out.print(a);
				break;
			case 87:
				a = 84;
				System.out.print(a);
				break;
			case 88:
				a = 85;
				System.out.print(a);
				break;
			case 89:
				a = 86;
				System.out.print(a);
				break;
			case 90:
				a = 87;
				System.out.print(a);
				break;
			}

			s.close();
		}
	}
}
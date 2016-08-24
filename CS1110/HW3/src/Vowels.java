import java.util.Scanner;


public class Vowels {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String c = s.nextLine();
		int length = c.length();
		int numa = 0;
		int nume = 0;
		int numi = 0;
		int numo = 0;
		int numu = 0;
		char a = 0;

		for (int i = 0; i<length; ++i){
			a = c.charAt(0+i);
			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A'|| a == 'E' || a == 'I' || a == 'O' || a == 'U' ){
				if (a == 'a' || a == 'A'){numa += 1;}
				else if (a == 'e'|| a == 'E'){nume += 1;}
				else if (a == 'i'|| a == 'I'){numi += 1;}
				else if (a == 'o'|| a == 'O'){numo += 1;}
				else if (a == 'u'|| a == 'U'){numu += 1;}
			}		
		}
		System.out.println("A: " + numa);
		System.out.println("E: " + nume);
		System.out.println("I: " + numi);
		System.out.println("O: " + numo);
		System.out.print("U: " + numu);
		s.close();
	}

}

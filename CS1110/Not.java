import java.util.Scanner;


public class Not {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);
		System.out.print("Type true or false: ");
		boolean b = keyboard.nextBoolean();
		if (b == false){
			boolean b2 = true;
			System.out.print(b2);
		}
		if (b == true ){
			
			boolean b1 = false;
			System.out.print(b1);
			
		
		}
		keyboard.close();
		
	}
}
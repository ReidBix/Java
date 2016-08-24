import java.text.DecimalFormat;
import java.util.Scanner;


public class ShoppingCart {

	public static void main(String[] args) {
		
		System.out.println("Shopping Cart");
		System.out.println("-------------\n");
		
		Scanner s = new Scanner(System.in);
		int x = 1;
		int i = 0;
		double d1 = 0;
				
		while (x != 0){
		++i;
		System.out.print("Enter Item " +i+ " Price (0 to stop): ");
		double d3 = s.nextDouble();
		if (d3==0){
			--i;
			break;
		}
		else {
		double d2 = d3;
		d1 = d2 + d1;
		
		}
		}
		double d1i = d1/i;
		
		DecimalFormat fmt = new DecimalFormat("0.00");
		String double1 = fmt.format(d1);
		String double1i = fmt.format(d1i);
		
		if (i==0){
		System.out.println("Total Items Bought: " + i);
		System.out.println("Total Cost: $" + double1);
		System.out.print("Avg Item Cost: $0.00");
		}
		else{
		System.out.println("Total Items Bought: " + i);
		System.out.println("Total Cost: $" + double1);
		System.out.print("Avg Item Cost: $" + double1i);
		}
		s.close();
	}

}

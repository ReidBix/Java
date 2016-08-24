import java.text.DecimalFormat;
import java.util.Scanner;

/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 11, 2013

*/

public class Hybrid {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Hybrid Car Value Calculator");
		System.out.println("---------------------------\n");
		
		System.out.print("What is the cost of a new hybrid car?: ");
		double newcar = keyboard.nextInt();
		
		System.out.print("What is the cost of a comparison car?: ");
		double compcar = keyboard.nextInt();
		
		System.out.print("Estimated miles driven per year?: ");
		double miles = keyboard.nextInt();
		
		System.out.print("Estimated gas price (per gallon)?: ");
		double gas = keyboard.nextDouble();
		
		System.out.print("Estimated miles per gallon for the hybrid?: ");
		double mpgnew = keyboard.nextInt();
		
		System.out.print("Estimated miles per gallon for the comparison car?: ");
		double mpgcomp = keyboard.nextInt();
		
		double costnew1yr = newcar + (miles/mpgnew)*gas;
		double costnew5yr = newcar + 5*(miles/mpgnew)*gas;
		double costnew10yr = newcar + 10*(miles/mpgnew)*gas;
		
		double costcomp1yr = compcar + (miles/mpgcomp)*gas;
		double costcomp5yr = compcar + 5*(miles/mpgcomp)*gas;
		double costcomp10yr = compcar + 10*(miles/mpgcomp)*gas;
		
		DecimalFormat fmt = new DecimalFormat("0.00");
		String costnew1yrdf = fmt.format(costnew1yr);
		String costnew5yrdf = fmt.format(costnew5yr);
		String costnew10yrdf = fmt.format(costnew10yr);
		String costcomp1yrdf = fmt.format(costcomp1yr);
		String costcomp5yrdf = fmt.format(costcomp5yr);
		String costcomp10yrdf = fmt.format(costcomp10yr);
		
		System.out.println("\nCost of the hybrid car after 1 / 5 / 10 years: $" + costnew1yrdf + " / $" + costnew5yrdf + " / $" + costnew10yrdf);
		System.out.println("Cost of the comparison car after 1 / 5 / 10 years: $" + costcomp1yrdf + " / $" + costcomp5yrdf + " / $" + costcomp10yrdf);
		
		keyboard.close();
		
	}

}

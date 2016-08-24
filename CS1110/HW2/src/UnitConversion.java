/**
* Name: Reid Bixler
* Computing ID: rmb3yz
* Lab Section: 1110-102
* Date: September 18, 2013

*/


import java.text.DecimalFormat;
import java.util.Scanner;


public class UnitConversion {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Convert from English unit? ");
		String eng = s.nextLine();
		System.out.print("Convert to Metric unit? ");
		String met = s.nextLine();
		System.out.print("Amount? ");
		double amt = s.nextDouble();
		double ans = 0.0;
		int a = 0;
		
		//volume
		if(eng.equals("pt")){
			if (met.equals("ml")){
				ans = amt*473.176;
			}
			else if (met.equals("l")){
				ans = amt*.473176;
			}
			else{
				a = 1;
				System.out.println("Improper Conversion!");
			}
		}
		else if (eng.equals("gal")){
			if (met.equals("ml")){
				ans = amt*3785.41178;
			}
			else if (met.equals("l")){
				ans = amt*3.78541178;
			}
			else{
				a = 1;
				System.out.println("Improper Conversion!");
			}
		}
		
		
		//length
		else if(eng.equals("ft")){
			if(met.equals("m")){
				ans = amt*.3048;
			}
			else if (met.equals("km")){
				ans = amt*.0003048;
			}
			else{
				a = 1;
				System.out.println("Improper Conversion!");
			}
		}
		else if (eng.equals("mi")){
			if (met.equals("m")){
				ans = amt*1609.34;
			}
			else if (met.equals("km")){
				ans = amt*1.60934;
			}
			else{
				a = 1;
				System.out.println("Improper Conversion!");
			}
		}
	
		
		//weight
		else if(eng.equals("oz")){
			if(met.equals("g")){
				ans = amt*28.3495;
			}
			else if (met.equals("kg")){
				ans = amt*0.0283495;
			}
			else{
				a = 1;
				System.out.println("Improper Conversion!");
			}
		}
		
		else if (eng.equals("lb")){
			if (met.equals("g")){
				ans = amt*453.592;
			}
			else if (met.equals("kg")){
				ans = amt*0.453592;
			}
			else{
				a = 1;
				System.out.println("Improper Conversion!");
			}
		}
					
		else{
				a = 1;
				System.out.println("Improper Conversion!");
		}
		if (a==0){
		DecimalFormat fmt = new DecimalFormat("0.0000");
		String answ = fmt.format(ans);
		System.out.println(amt + " " + eng + " = " + answ + " " + met);
		}
		s.close();	
	}
	
	
	
		
}

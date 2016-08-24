import java.util.Scanner;


public class Nim {

	public static void main(String[] args) {
		
		System.out.println("The Game of Nim\n");
		
		Scanner s = new Scanner(System.in);
		System.out.print("Number of marbles are in the pile: ");
		int num = s.nextInt();
		System.out.print("Who will start? (p or c): ");
		String str = s.next();
		
		int take = num/2;
		double div = 0;
		int i2 = 0;
		int ctake = 0;
		int left = 0;
		int maxtake = num/2;
		
		char firstplyr = str.charAt(0);
		System.out.println("The pile has " + num + " marbles in it.");
		
		if (firstplyr == 'c'){
			while (num >= 1 ){
				//computer
				take = num/2;
				i2 = 0;
				div = 0;
				if (take == 0){take = 1;}
				while(take>=div){ 
					div = Math.pow(2,i2);
					++i2;
				}
				left = (int) (div - 1);	
				ctake = num - left;
				
				if (left == 1){ctake = 1;}
				else if (ctake >= take){
					if (ctake == 2){ctake=2;}
					else ctake = 1;}
				
				else if (ctake == 0){ctake =1;}

				
				num = num - ctake;

				if (num == 0){
					System.out.println("The computer takes " + ctake + " marble(s).");
					System.out.print("The player wins!");
					break;
				}
				System.out.println("The computer takes " + ctake + " marble(s).");
				System.out.println("The pile has " + num + " marbles in it.");		
				
				maxtake = num/2;
				if (maxtake == 0){maxtake = 1;}
				//player
				System.out.print("How many marbles do you want to take? (1-" + maxtake + "): ");
				int ptake = s.nextInt();
				while (ptake > maxtake || ptake < 1){
					System.out.print("How many marbles do you want to take? (1-" + maxtake + "): ");
					ptake = s.nextInt();
				}
				num = num - ptake;
				if (num == 0){
					System.out.print("The computer wins!");
					break;
				}
				System.out.println("The pile has " + num + " marbles in it.");
			}
		}
		else if (firstplyr == 'p'){
			while (num >= 1 ){
				
				maxtake = num/2;
				if (maxtake == 0){maxtake = 1;}
				//player
				System.out.print("How many marbles do you want to take? (1-" + maxtake + "): ");
				int ptake = s.nextInt();
				while (ptake > maxtake || ptake < 1){
					System.out.print("How many marbles do you want to take? (1-" + maxtake + "): ");
					ptake = s.nextInt();
				}
				num = num - ptake;
				if (num == 0){
					System.out.print("The computer wins!");
					break;
				}
				System.out.println("The pile has " + num + " marbles in it.");
				
				//computer
				take = num/2;
				i2 = 0;
				div = 0;
				if (take == 0){take = 1;}
					while(take>=div){ 
						div = Math.pow(2,i2);
						++i2;
					}
					left = (int) (div - 1);
					
					ctake = num - left;
					if (left == 1){ctake = 1;}
					else if (ctake >= take){
						if (ctake == 2){ctake=2;}
						else ctake = 1;}
					else if (ctake == 0){ctake =1;}

					num = num - ctake;

				
				if (num == 0){
					System.out.println("The computer takes " + ctake + " marble(s).");
					System.out.print("The player wins!");
					break;
				}
				System.out.println("The computer takes " + ctake + " marble(s).");
				System.out.println("The pile has " + num + " marbles in it.");			
				
			}
		}
		s.close();
	}

}
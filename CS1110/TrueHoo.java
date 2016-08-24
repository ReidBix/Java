import java.util.Scanner;


public class TrueHoo {

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("Answer all questions with 'y' for yes or 'n' for no.");
		
		int count = 0;
		
		System.out.print("Do you attend the University of Virginia?");
		String ans = keyboard.nextLine();
		
		if (ans.charAt(0)=='y'){
			count = count + 1;			
		}
		if (ans.charAt(0)=='n'){
			count = count;
		}
				
		
		System.out.print("Do you know the words of the Good Ol' Song?");
		String ans2 = keyboard.nextLine();
		
		if (ans2.charAt(0)=='y'){
			count = count + 1;			
		}
		if (ans2.charAt(0)=='n'){
			count = count;
		}
				
		
		

		System.out.print("Have you eaten a Gusburger at the White Spot?");
		String ans3 = keyboard.nextLine();
		
		if (ans3.charAt(0)=='y'){
			count = count + 1;			
		}
		if (ans3.charAt(0)=='n'){
			count = count;
		}
				
		System.out.print("Have you toured the Rotunda?");
		String ans4 = keyboard.nextLine();
		
		if (ans4.charAt(0)=='y'){
			count = count + 1;			
		}
		if (ans4.charAt(0)=='n'){
			count = count;
		}
			
		
		System.out.print("Have you signed the Honor Pledge?");
		String ans5 = keyboard.nextLine();
		
		if (ans5.charAt(0)=='y'){
			count = count + 1;			
		}
		if (ans5.charAt(0)=='n'){
			count = count;
		}
		
	if(count==5){	
		System.out.println(count + " yes - You are a True Hoo!");
	}
		
		
	if(count==4){	
		System.out.println(count + " yes - You are almost a True Hoo!");
	}
	
	
	if(count==3){	
		System.out.println(count + " yes - You're on your way to being a True Hoo!");
	}
	
	
	
	if(count==2){	
		System.out.println(count + " yes - You're a Hoo Novice!");
	}
	
	
	if(count==1){	
		System.out.println(count + " yes - You're a Baby Hoo!");
	}
	
	
	if(count==0){	
		System.out.println(count + " yes - You're a Hokie!");
	}
	keyboard.close();
	}
	



}

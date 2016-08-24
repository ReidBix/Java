
public class repeatFront {

	public static void main(String[] args) {
		System.out.println(repeatFront("Chocolate",4));
	}
	
	public static String repeatFront(String str, int n) {
		String newString = "";
		

		for (int i = 0; i < n; ++i){
			String sub = str.substring(0, n-i);
			newString = newString + sub;
		}
		
		
		return newString;
		  
	}

}

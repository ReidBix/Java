public class stringBits {
	public static void main(String[] args){
	System.out.println(stringBits("Hello"));
	
	
	}
	
	public static String stringBits(String str) {
		int strLength = str.length();
		
		String newString = "";
		
		for (int i = 0; i < strLength; i = i + 2) {
		char letter = str.charAt(i);
		newString = newString + letter;
		
		}

		return newString;

	}
	
}

public class stringX {

	public static void main(String[] args) {
		System.out.println(stringX(""));
	}

	public static String stringX(String str) {
		int strLength = str.length();

		String newString = "";
		
		if (strLength != 0){
			char a = str.charAt(0);
			newString = newString + a;
		}
		

		for (int i = 1; i < strLength - 1; ++i) {
			char letter = str.charAt(i);
			if (letter != 'x') {
				newString = newString + letter;
			}
		}
		
		if (strLength > 1) {
			char z = str.charAt(strLength - 1);
			newString = newString + z;
		}
		

		return newString;
	}

}

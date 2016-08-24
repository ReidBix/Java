/**
 * Recursion.java
 * 
 * Example recursion problems to work for Lab 13
 * 
 * @author Mark Sherriff
 * 
 */

public class Recursion {

	public static void main(String[] args) {

		int countX = 0;
		int noX = 0;
		int findMinInArray = 0;
		int endX = 0;
		int reverse = 0;
		int sumDigits = 0;

		if (countX("xxhixx") == 4) {
			countX++;
		}
		if (countX("bubba") == 0) {
			countX++;
		}
		if (countX("") == 0) {
			countX++;
		}

		if (noX("xxxmarkxxx").equals("mark")) {
			noX++;
		}
		if (noX("mark").equals("mark")) {
			noX++;
		}
		if (noX("").equals("")) {
			noX++;
		}

		if (findMinInArray(new int[] { 4, 6, 3, 4, 6, 7, 0 }) == 0) {
			findMinInArray++;
		}
		if (findMinInArray(new int[] { 3, 5, 1, 2 }) == 1) {
			findMinInArray++;
		}
		if (findMinInArray(new int[] { 23 }) == 23) {
			findMinInArray++;
		}

		if (endX("xxxzx").equals("zxxxx")) {
			endX++;
		}
		if (endX("xrrxxrr").equals("rrrrxxx")) {
			endX++;
		}
		if (endX("").equals("")) {
			endX++;
		}

		if (reverse("hope").equals("epoh")) {
			reverse++;
		}
		if (reverse("bubba").equals("abbub")) {
			reverse++;
		}
		if (reverse("").equals("")) {
			reverse++;
		}

		if (sumDigits(4562) == 17) {
			sumDigits++;
		}
		if (sumDigits(1) == 1) {
			sumDigits++;
		}
		if (sumDigits(536) == 14) {
			sumDigits++;
		}

		System.out.println("countX - " + countX + " out of 3");
		System.out.println("noX - " + noX + " out of 3");
		System.out.println("findMinInArray - " + findMinInArray + " out of 3");
		System.out.println("endX - " + endX + " out of 3");
		System.out.println("reverse - " + reverse + " out of 3");
		System.out.println("sumDigits - " + sumDigits + " out of 3");

	}

	/**
	 * 
	 * Given a string, compute recursively (no loops) the number of lowercase
	 * 'x' chars in the string.
	 * 
	 * countX("xxhixx") -> 4 countX("xhixhix") -> 3 countX("hi") -> 0
	 * 
	 * @param str
	 *            - The string to search
	 * @return the number of lowercase 'x' chars
	 */
	public static int countX(String str) {
		if (str.length() == 0){
			return 0;
		}
		if (str.charAt(0) == 'x'){
			return 1 + countX(str.substring(1));
		}
		return countX(str.substring(1));
	}

	/**
	 * 
	 * Given a string, compute recursively a new string where all the 'x' chars
	 * have been removed.
	 * 
	 * noX("xaxb") -> "ab" noX("abc") -> "abc" noX("xx") -> ""
	 * 
	 * @param str
	 *            - The string to search
	 * @return the string with no 'x's in it
	 */
	public static String noX(String str) {
		if (str.length() == 0){
			return "";
		}
		if (str.charAt(0) == 'x'){
			return noX(str.substring(1));
		}
		return str.charAt(0) + noX(str.substring(1));
	}
		

	/**
	 * 
	 * Given an array of ints, recursively find the smallest number. Do this by
	 * splitting the array in half to check each half for its min, then split
	 * again and again until you reach an array of size 1, which would be the
	 * min. Compare the returns to find the min.
	 * 
	 * 
	 * @param int[] - The array to check
	 * @return the min value
	 */
	public static int findMinInArray(int[] arr) {
		if (arr.length == 1){
			return 0;
		}
		if (arr.length > 1){
			int halflength = arr.length/2;
			//int[] arr1 = arr.
			//return findMinInArray(arr[halflength] );
		}
		return -1; // Change this!
	}

	/**
	 * Given a string, compute recursively a new string where all the lowercase
	 * 'x' chars have been moved to the end of the string.
	 * 
	 * endX("xxre") → "rexx" endX("xxhixx") → "hixxxx" endX("xhixhix") →
	 * "hihixxx"
	 * 
	 * @param str
	 *            - The string to manipulate
	 * @return the changed string
	 */
	public static String endX(String str) {
		if (str.length() == 0){
			return "";
		}
		if (str.charAt(0) == 'x'){
			return endX(str.substring(1)) + str.charAt(0);
		}
		return str.charAt(0) + endX(str.substring(1));
	}
	

	/**
	 * Given a string, return the reverse of it.
	 * 
	 * reverse("hope") -> "epoh" reverse("bubba") -> "abbub"
	 * 
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		if (str.length() == 0){
			return "";
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
	

	/**
	 * Given a non-negative int n, return the sum of its digits recursively (no
	 * loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is
	 * 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
	 * 
	 * sumDigits(126) -> 9 sumDigits(49) -> 13 sumDigits(12) -> 3
	 * 
	 * @param int
	 * @return the sum of the digits
	 */
	public static int sumDigits(int n) {
		if (n%10 == 0 && n/10 == 0){
			return 0;
		}
		if (n < 10){
			//return sumDigits;
		}
		return -1;
	}

}
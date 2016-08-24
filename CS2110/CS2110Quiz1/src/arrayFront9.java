public class arrayFront9 {

	public static boolean arrayFront9(int[] nums) {
		int numsLength = nums.length;

		int total = 0;
		boolean nineTrue = false;
		
		if (numsLength >= 4) {
			for (int i = 0; i < 4; ++i) {
				int x = nums[i];
				if (x == 9) {
					nineTrue = true;
				}
			}
		} else {
			for (int i = 0; i < numsLength; ++i) {
				int x = nums[i];
				if (x == 9) {
					nineTrue = true;
				}
			}
		}

		return nineTrue;
	}

}

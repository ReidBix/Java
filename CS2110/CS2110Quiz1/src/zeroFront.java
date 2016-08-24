import java.util.Arrays;

public class zeroFront {

	public static void main(String[] args) {
		int[] ary = new int[] { 1, 0, 0, 1 };
		
		System.out.println(Arrays.toString(ary));
		
		System.out.println(Arrays.toString(zeroFront(ary)));
		
	}

	public static int[] zeroFront(int[] nums) {
		int numsLength = nums.length;

		int[] newArray = new int[numsLength];

		int zeroCount = 0;

		for (int i = 0; i < numsLength; ++i) {
			int x = nums[i];
			if (x == 0) {
				newArray [zeroCount] = 0;
				zeroCount++;
			}
		}

		for (int i = 0; i < numsLength; ++i) {
			int x = nums[i];
			if (x != 0) {
				newArray [zeroCount] = x;
				zeroCount++;
			}
		}

		return newArray;
	}
}

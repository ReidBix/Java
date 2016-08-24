
public class array667 {

	public static void main(String[] args) {

	}

	public static int array667(int[] nums) {
		int numsLength = nums.length;
		
		int total = 0;
		
		for (int i = 0; i<numsLength-1;++i){
			int x = nums[i];
			int y = nums[i+1];
			if (x==6){
				if (y == 6 || y == 7){
					++total;
				}
			}
		}

		return total;
	}
}

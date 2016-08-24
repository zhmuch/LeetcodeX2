import java.util.*;

public class Lc_Sum{
	
	//	LC001 Two Sum;
	public int[] twoSum(int[] nums, int target) {
        	
		int len = nums.length;
		if (len < 2)
			return null;

		HashMap<Integer, Integer> map = new HashMap<>();	

		for(int i = 0; i < len; i++) {
			int remain = target - nums[i];
			if(map.containsKey(remain)) {
				return new int[] {map.get(remain), i};
			}
			map.put(nums[i], i);
		}
		
		return null;
    	}			

	//	LC167 Two Sum II - Input array is sorted;
	public int[] twoSumSorted(int[] numbers, int target) {
        	
		int len = numbers.length;
		if (len < 2) 
			return null;

		int left = 0, right = len - 1;
		while(left < right){
			int tmp = numbers[left] + numbers[right];
			if (tmp == target) {
				return new int[] {left + 1, right + 1};
			} else if (tmp > target) {
				right--;
			} else {
				left++;	
			}
		}
		
		return null;
    	}

	public static void main(String[] args) {
		
		Lc_Sum test = new Lc_Sum();
		
		// Two Sum;
		int[] nums = {2, 7, 11, 15};
		int[] twoSumRes = test.twoSum(nums, 9);
		for (int i : twoSumRes)
			System.out.print(i + " ");
		System.out.println();
		
	}

}

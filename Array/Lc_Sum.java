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

	//	LC015 Three Sum;
	public List<List<Integer>> threeSum(int[] nums) {
       		
		List<List<Integer>> res = new LinkedList<>();
		int len = nums.length;
		if (len < 3) 
			return res;
		
		Arrays.sort(nums);
		for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {
			int target = 0 - nums[i];
			threeSumHelper(res, nums, target, i + 1, len - 1);
			while(i < len - 1 && nums[i] == nums[i + 1])
			    i++;
		}
				
		return res;
	}

	public void threeSumHelper(List<List<Integer>> res, int[] nums, int target, int left, int right) {
		while(left < right) {
			if (nums[left] + nums[right] == target) {
				List<Integer> tmp = new LinkedList<>();
				tmp.add(-target);
				tmp.add(nums[left]);
				tmp.add(nums[right]);
				res.add(tmp);		
				
				while(left < right && nums[left] == nums[left + 1])
					left++;
				while(left < right && nums[right] == nums[right - 1])
					right--;
				left++;
				right--;
			} else if (nums[left] + nums[right] < target) {
				while(left < right && nums[left] == nums[left + 1])
					left++;
				left++;
			} else {
				while(left < right && nums[right] == nums[right - 1])
					right--;
				right--;
			}
		}
		return;
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

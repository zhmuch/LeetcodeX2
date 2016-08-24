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

	//	4Sum
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3 && nums[i] <= target / 4; ++i){
            for(int j = i + 1; j < nums.length - 2 && nums[i] + nums[j] <= target / 2; ++j){
                int sum = nums[i] + nums[j];
                int x = j + 1, y = nums.length - 1;
                while(x  < y){
                    if(sum + nums[x] + nums[y] == target){
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[x]);
                        tmp.add(nums[y]);
                        result.add(tmp);
                        while(x < y && nums[x + 1] == nums[x])++x;
                        ++x;
                        while(y > x && nums[y - 1] == nums[y])--y;
                        --y;
                    }else if(sum + nums[x] + nums[y] < target){
                        ++x;
                    }else{
                        --y;
                    }
                }
            while(j < nums.length - 2 && nums[j + 1] == nums[j])++j;
            }
            while(i < nums.length - 3 && nums[i + 1] == nums[i])++i;
        }
        return result;
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

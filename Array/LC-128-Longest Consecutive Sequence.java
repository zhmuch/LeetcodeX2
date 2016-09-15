public class Solution {
    /**
     * Sort
     * 
     * O(nlogn)
     */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        
        int count = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1)
                count = 1;
            
            if (nums[i] - nums[i - 1] == 1)
                count++;

            max = Math.max(count, max);
        }
        
        return max;
    }
}

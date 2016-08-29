public class Solution {

    /**
     * Greedy;
     *
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], curr = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        
        return max;
    }
}

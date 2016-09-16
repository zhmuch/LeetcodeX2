public class Solution {
    /**
     * Two Pointer;
     * 
     * O(n)
     * 
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int left = 0, right = 0, sum = nums[0], len = Integer.MAX_VALUE;
        
        while (true) {
            if (sum < s) {
                right++;
                if (right >= nums.length)
                    break;
                sum += nums[right];
            } else {
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }
}

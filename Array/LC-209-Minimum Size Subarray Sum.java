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
    
    /**
     * Binary Search;
     * 
     * O(n log n)
     * 
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int[] sums = new int[nums.length + 1];
        sums[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            len = Math.min(len, getLength(sums, i, s));
        }
        
        return (len == Integer.MAX_VALUE) ? 0 : len;
    }
    
    private int getLength(int[] sums, int start, int s) {
        int end = sums.length - 1;
        
        /* 二分 */
        
    }
}

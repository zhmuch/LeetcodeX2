public class Solution {
    /**
     * O(n)
     * 
     */
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        
        int curr = 0, sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            curr += i * nums[i];
        }
        
        int max = curr;
        
        for (int i = 1; i < nums.length; i++) {
            curr = curr + sum - nums[nums.length - i] * nums.length;
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
    
    /**
     * Time Limit Exceed;
     * 
     * O(n^2)
     * 
     */
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1)
            return 0;
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            int curr = 0;
            
            for (int j = 0; j < A.length; j++) {
                curr += j * A[(j - i + A.length) % A.length];
            }
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
}

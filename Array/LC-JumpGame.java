public class Solution {
    
    /**
     *LC55. Jump Game
     * 
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        
        for(int i = 0; i <= max && i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1)
                return true;
        }
        
        return false;
    }
    
}

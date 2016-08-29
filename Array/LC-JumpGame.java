public class Solution {
    
    /**
     * LC55. Jump Game
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
    
    
    /**
     * LC45. Jump Game II
     * 
     */
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int start = 0, end = 0, max = 0, step = 0;
        
        while(true) {
            for (int i = start; i <= end; i++) 
                max = Math.max(max, i + nums[i]);
            
            if (max == end)
                break;
            start = end + 1;
            end = max;
            
            step++;
            
            if (max >= nums.length - 1)
                return step;
        }
        
        return -1;
    }
}

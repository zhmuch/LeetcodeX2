public class Solution {
    
    /**
     * Remove Duplicates;
     * 
     * Leetcode 026
     * 
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1)
            return 0;
            
        int slow = 0, fast = 1, prev = nums[0];
        
        
        while(fast < nums.length) {
            if (nums[fast] == prev)
                fast++;
            else {
                nums[++slow] = nums[fast];
                prev = nums[fast++];
            }
        }
        
        return slow + 1;
    }
    
    /**
     * Duplicates are allowed at most twice;
     * 
     * Leetcode 080
     * 
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1)
            return 0;
        if (nums.length == 1)
            return 1;
            
        int start, idx;
        if (nums[0] == nums[1]) {
            start = 2;
            idx = 1;
        } else {
            start = 1;
            idx = 0;
        }
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[idx])
                continue;
            else {
                nums[++idx] = nums[i];
                if (i + 1 < nums.length && nums[i] == nums[i + 1])
                    nums[++idx] = nums[++i];
            }
        }
        
        return idx + 1;
    }
    
    /**
     * LC027. Remove Element
     * 
     */
    public int removeElement(int[] nums, int val) {
        int idx = 0, len = nums.length;
        
        while (idx < len) {
            if (nums[idx] == val) {
                len--;
                nums[idx] = nums[len];
            } else {
                idx++;
            }
        }
        
        return len;
    }
}

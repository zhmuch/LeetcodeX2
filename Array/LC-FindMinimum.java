public class Solution {

    /**
     * Without Duplicates;
     * 
     * Leetcode 153;
     *
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len < 1)
            return -1;
        if (nums[len - 1] > nums[0])
            return nums[0];
            
        int left = 0, right = len - 1;
        
        while(left <= right) {
            
            int med = (left + right) / 2;
            
            if (med == 0)
                return Math.min(nums[left], nums[right]);
            else if (nums[med - 1] > nums[med])
                return nums[med];
            else if (nums[0] < nums[med])
                left = med + 1;
            else
                right = med - 1;
        }
        
        return -1;
    }
    

    /**
     * With Duplicates;
     * 
     * Leetcode 154;
     * 
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        
        while(left < right) {
            int med = left + (right - left) / 2;
            
            if (nums[med] < nums[right])
                right = med;
            else if (nums[med] > nums[right])
                left = med + 1;
            else
                right--;
        }
        
        return nums[right];
    }
}

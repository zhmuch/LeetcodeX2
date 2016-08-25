public class Solution {

    // Without Duplicates;
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
    

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len < 1)
            return -1;
        
        if (nums[0] < nums[len - 1])
            return nums[0];
            
        int left = 0, right = len - 1;
        
        while(nums[left] == nums[len - 1]) {
            left++;
            if (left >= len - 1)
                return nums[len - 1];
        }
        
        while(left <= right) {
            System.out.println()
            
            int med = (left + right) / 2;
            
            if (med == left)
                return Math.min(nums[left], nums[right]);
            else if (nums[med - 1] > nums[med])
                return nums[med];
            else if (nums[med] > nums[left])
                left = med + 1;
            else
                right = med - 1;
        }
        
        return -1;
        
    }
}

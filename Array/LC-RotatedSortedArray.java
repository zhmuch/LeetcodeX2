public class Solution {
    
    /**
     * Without Duplicates
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1)
            return -1;
        
        int left = 0, right = len - 1;
        while(left <= right) {
            int med = (left + right) / 2;
            if (nums[med] == target)
                return med;
            else if (nums[med] >= nums[left]) {
                if (nums[med] > target && target >= nums[left])
                    right = med - 1;
                else
                    left = med + 1;
            } else {
                if (nums[med] < target && target <= nums[right])
                    left = med + 1;
                else
                    right = med - 1;
            }
        }
        return -1;
    }
    
    /**
     * With Duplicates
     */
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1)
            return false;
        
        int left = 0, right = len - 1;
        while(left <= right) {
            int med = (left + right) / 2;
            if (nums[med] == target)
                return true;
             else if (nums[med] > nums[left]) {
                if (nums[med] > target && target >= nums[left])
                    right = med - 1;
                else
                    left = med + 1;
            } else if (nums[med] < nums[left]) {
                if (nums[med] < target && target <= nums[right])
                    left = med + 1;
                else
                    right = med - 1;
            } else {
                while(left < right && nums[left] == nums[left + 1])
                    left++;
                left++;
            }
        }
        
        return false;
    }
}

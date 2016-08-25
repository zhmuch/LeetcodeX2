public class Solution {
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
}

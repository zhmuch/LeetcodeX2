public class Solution {
    /**
     * LC034. Search for a Range
     * 
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int idx = -1;
        int left = 0, right = nums.length - 1;
        
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            
            if (nums[mid] == target) {
                idx = mid;
                break;
            } else if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        if (idx == -1)
            return res;
        
        right = idx;
        while(right < nums.length && nums[right] == target)
            right++;
        
        left = idx;
        while(left >= 0 && nums[left] == target)
            left--;
            
        res[0] = left + 1;
        res[1] = right - 1;
        
        return res;
    }
}

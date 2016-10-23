public class Solution {
    public int missingNumber(int[] nums) {
        int max = nums.length;
        
        for (int i = 0; i < max; i++) {
            while (nums[i] != i && nums[i] != max) {
                swap(nums, i, nums[i]);
            }
        }
        
        for (int i = 0; i < max; i++)
            if (nums[i] != i)
                return i;
                
        return max;
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

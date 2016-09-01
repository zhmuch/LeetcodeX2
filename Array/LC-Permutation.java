public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return;
            
        int idx = len - 1;
        while (idx > 0 && nums[idx - 1] >= nums[idx])
            idx--;
        idx--;
        
        if (idx < 0) {
            for (int i = 0; i < len / 2; i++)
                swap(nums, i, len - 1 - i);
        } else {
            int ins = len - 1;
            while (nums[ins] <= nums[idx])
                ins--;
                
            swap(nums, ins, idx);
            
            for (int i = idx + 1; i <= (len + idx) / 2; i++) {
                swap(nums, i, len + idx - i);
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

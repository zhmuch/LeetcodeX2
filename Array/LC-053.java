public class Solution {

    /**
     * Greedy;
     *
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], curr = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }
        
        return max;
    }
    
    /**
     * Divide and Conquer;
     * 
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int pivot = (nums.length - 1) / 2;

        return Math.max(maxSubArray(nums, 0, nums.length - 1, pivot), Math.max(maxSubArray(nums, 0, pivot), maxSubArray(nums, pivot + 1, nums.length - 1)));
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int pivot = (left + right) / 2;

        return Math.max(maxSubArray(nums, left, right, pivot), Math.max(maxSubArray(nums, left, pivot), maxSubArray(nums, pivot + 1, right)));
    }

    private int maxSubArray(int[] nums, int left, int right, int pivot) {
        if (left == right)
            return nums[left];

        int lmax = nums[pivot], tmp = nums[pivot];

        for(int i = pivot - 1; i >= left; i--) {
            tmp += nums[i];
            lmax = Math.max(lmax, tmp);
        }
        
        if (pivot >= right)
            return lmax;

        int rmax = nums[pivot + 1];
        tmp = nums[pivot + 1];

        for(int i = pivot + 2; i <= right; i++) {
            tmp += nums[i];
            rmax = Math.max(rmax, tmp);
        }
        
        return lmax + rmax;
    }
}

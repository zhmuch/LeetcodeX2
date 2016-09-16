public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        
        int accu = 1;
        for (int i = 1; i < nums.length; i++) {
            accu *= nums[i - 1];
            res[i] = accu; 
        }
        
        accu = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            accu *= nums[i + 1];
            res[i] *= accu;
        }
        
        return res;
    }
}

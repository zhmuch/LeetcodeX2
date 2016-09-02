public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        
        int[] tmp = new int[len];
        System.arraycopy(nums, 0, tmp, 0, len);
        
        System.arraycopy(tmp, 0, nums, k, len - k);
        System.arraycopy(tmp, len - k, nums, 0, k);
        
        return;    
    }
}

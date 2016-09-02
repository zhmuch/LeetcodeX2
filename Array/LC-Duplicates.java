public class Solution {
    
    /**
     * 用Bit位来代替Set，
     * 储存出现过的数字；
     */
    public boolean containsDuplicate(int[] nums) {
        byte[] mark = new byte[150000];
        for (int i : nums) {
            int j = i/8;
            int k = i%8;
            int check = 1<<k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j]|=check;
        }
        return false;
    }
    
    
    /**
     * 排序
     * 
     * 再逐一判重；
     * 
     * 低效
     * 
     */
    

    /**
     * HashSet
     * 超时！
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            if (set.contains(i))
                return true;
            else
                set.add(i);
        return false;
    }
    
    
    /**
     * 219. Contains Duplicate II
     * 
     * 滑动窗口
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i <= k && i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        
        if (k >= nums.length - 1)
            return false;
        
        for (int j = k + 1; j < nums.length; j++) {
            set.remove(nums[j - k - 1]);
            if (set.contains(nums[j]))
                return true;
            else
                set.add(nums[j]);
        }
        
        return false;
    }
}

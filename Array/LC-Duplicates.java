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
}

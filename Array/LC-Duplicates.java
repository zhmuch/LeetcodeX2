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
    
    
    /**
     * LC220. Contains Duplicate III
     * 
     * Buckets
     * 
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
    
    
    /**
     * LC220. Contains Duplicate III
     * 
     * TreeSet<>
     * 
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {  
        //input check  
        if(k<1 || t<0 || nums==null || nums.length<2) return false;  
          
        SortedSet<Long> set = new TreeSet<Long>();  
          
        for(int j=0; j<nums.length; j++) {  
            SortedSet<Long> subSet =  set.subSet((long)nums[j]-t, (long)nums[j]+t+1);  
            if(!subSet.isEmpty()) return true;  
              
            if(j>=k) {  
                set.remove((long)nums[j-k]);  
            }  
            set.add((long)nums[j]);  
        }  
        return false;  
    }  
}

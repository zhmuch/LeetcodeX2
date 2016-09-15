public class Solution {
    /**
     * Sort
     * 
     * O(nlogn)
     */
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        
        int count = 1, max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1)
                count = 1;
            
            if (nums[i] - nums[i - 1] == 1)
                count++;

            max = Math.max(count, max);
        }
        
        return max;
    }
    
    /**
     * Union Find
     * 
     * O(n)
     * 
     */
    public int longestConsecutive(int[] nums) {
        int max = 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                int left = (map.containsKey(i - 1)) ? map.get(i - 1) : 0;
                int right = (map.containsKey(i + 1)) ? map.get(i + 1) : 0;
                
                int sum = left + right + 1;
                
                max = Math.max(max, sum);
                
                map.put(i, sum);
                
                // Update Boundary;
                map.put(i - left, sum);
                map.put(i + right, sum);
            }
        }
        
        return max;
    }
}

public class Solution {
    /**
     * LC041. First Missing Positive
     * 
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) 
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
                
        
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;
        
        return nums.length + 1;
    }
    
    /**
     * LC162. Find Peak Element
     * 
     * O(N)
     * 
     */
    public int findPeakElement(int[] nums) {
        int maxIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIdx])
                maxIdx = i;
        }
        
        return maxIdx;
    }
    
    /**
     * LC162. Find Peak Element
     * 
     * O(logN)
     * 
     */
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }
    
    public int findPeakElement(int[] nums, int left, int right) {
        if (left == right)
            return left;
            
        int l = findPeakElement(nums, left, (left + right) / 2);
        int r = findPeakElement(nums, (left + right) / 2 + 1, right);
        
        return (nums[l] > nums[r]) ? l : r;
    }
    
    /**
     * LC287. Find the Duplicate Number
     * 
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int find = 0;
        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
}

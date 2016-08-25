public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1)
            return 0;
            
        int slow = 0, fast = 1, prev = nums[0];
        
        
        while(fast < nums.length) {
            if (nums[fast] == prev)
                fast++;
            else {
                nums[++slow] = nums[fast];
                prev = nums[fast++];
            }
        }
        
        return slow + 1;
    }
}

public class Solution {
    public int majorityElement(int[] nums) {
        int curr = -1, count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                curr = nums[i];
                count++;
            } else {
                if (nums[i] == curr)
                    count++;
                else
                    count--;
            }
        }
        
        return curr;
    }
}

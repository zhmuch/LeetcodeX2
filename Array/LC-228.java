public class Solution {
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> res = new LinkedList<>();
        
        if (nums == null || nums.length < 1)
            return res;
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        int start = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                continue;
            } else {
                if (i - 1 > start) {
                    sb.append("->" + nums[i - 1]);
                }
                
                res.add(sb.toString());
                sb = new StringBuilder();
                
                sb.append(nums[i]);
                start = i;
            }
        }
        
        if (nums.length - 1 > start)
            sb.append("->" + nums[nums.length - 1]);
        res.add(sb.toString());
        
        return res;
    }
}

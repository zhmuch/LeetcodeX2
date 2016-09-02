public class Solution {
    /**
     * LC078. Subsets
     * 
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        
        search(res, tmp, nums, 0);
        
        return res;
    }
    
    private void search(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        if (idx >= nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        search(res, tmp, nums, idx + 1);
        
        tmp.add(nums[idx]);
        search(res, tmp, nums, idx + 1);
        tmp.remove(tmp.size() - 1);
    }
    
    
    
    /**
     * LC090. Subsets II
     * 
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        
        search(res, tmp, nums, 0);
        
        return res;
    }
    
    private void search(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        if (idx >= nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        int next = idx + 1;
        while (next < nums.length && nums[next] == nums[next - 1])
            next++;
        search(res, tmp, nums, next);
        
        tmp.add(nums[idx]);
        search(res, tmp, nums, idx + 1);
        tmp.remove(tmp.size() - 1);
    }
}

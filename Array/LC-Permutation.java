public class Solution {
    
    /**
     * LC031. Next Permutation
     * 
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return;
            
        int idx = len - 1;
        while (idx > 0 && nums[idx - 1] >= nums[idx])
            idx--;
        idx--;
        
        if (idx < 0) {
            for (int i = 0; i < len / 2; i++)
                swap(nums, i, len - 1 - i);
        } else {
            int ins = len - 1;
            while (nums[ins] <= nums[idx])
                ins--;
                
            swap(nums, ins, idx);
            
            for (int i = idx + 1; i <= (len + idx) / 2; i++) {
                swap(nums, i, len + idx - i);
            }
        }
    }
    
    
    /**
     * LC046. Permutations
     * 
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        
        dfs(res, tmp, nums, 0);
        
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        if (idx >= nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            tmp.add(nums[idx]);
            
            dfs(res, tmp, nums, idx + 1);
            
            swap(nums, idx, i);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    
    /**
     * LC047. Permutations II
     * 
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        
        dfs(res, tmp, nums, 0);
        
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx) {
        if (idx >= nums.length) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        for (int ex = idx; ex < nums.length; ex++) {
            swap(nums, idx, ex);
            tmp.add(nums[idx]);
            
            dfs(res, tmp, nums, idx + 1);
            
            swap(nums, idx, ex);
            tmp.remove(tmp.size() - 1);
            
            while (ex < nums.length - 1 && nums[ex] == nums[ex + 1])
                ex++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

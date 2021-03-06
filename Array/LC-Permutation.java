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
     * ! ! ! ! ! ! 错误方法 ！ ！！！！！！！！！
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
    
    /**
     * LC046. Permutations
     * 
     * AC
     * 
     */
    List<List<Integer>> res;
    int[] nums;
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        if(nums == null || nums.length < 1)
            return res;

        this.nums = nums;
        Arrays.sort(this.nums);
        used = new boolean[nums.length];

        generate(new LinkedList<>(), 0);

        return res;
    }

    private void generate(List<Integer> curr, int x){
        if(x == nums.length)
            res.add(new LinkedList<>(curr));
        else {
            for (int i = 0; i < nums.length; i++)
                if (!used[i]) {
                    used[i] = true;
                    curr.add(nums[i]);
                    
                    generate(curr, x + 1);

                    used[i] = false;
                    curr.remove(curr.size() - 1);

                    while (i < nums.length - 1 && nums[i] == nums[i + 1])
                        i++;
                }
        }
    }
    
    
    /**
     * LC060. Permutation Sequence
     * 
     * 
     */
    public String getPermutation(int n, int k) {
        if(n == 1)
            return "1";

        String r = "";

        LinkedList<Integer> ref = new LinkedList<>();

        int s = 1;
        for(int i=1; i<=n; i++) {
            ref.add(i);
            s *= i;
        }

        for(int i=n; i>0; i--){
            s /= i;
            if(k != 0 && k % s == 0) {
                r = r + ref.remove(k / s - 1);
                break;
            }
            r = r + ref.remove(k / s);
            k %= s;
        }

        
        while(!ref.isEmpty())
            r = r + ref.removeLast();
      
        return r;
    }
}

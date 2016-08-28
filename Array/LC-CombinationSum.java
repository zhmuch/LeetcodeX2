public class Solution {
    
    /**
     * LC39. Combination Sum
     * 
     * unlimited number of use
     * 
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        Arrays.sort(candidates);
        
        prob(res, tmp, candidates, 0, target);
        
        return res;
    }
    
    private void prob(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        if (target < 0) 
            return;
        
        for(int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            prob(res, tmp, candidates, i, target - candidates[i]);
            tmp.remove(tmp.size() - 1);
            
            while(i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                i++;
        }
    }
    
    
    
    
    /**
     * LC40. Combination SumII
     * 
     * limited number;
     * 
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        Arrays.sort(candidates);
        
        prob(res, tmp, candidates, 0, target);
        
        return res;
    }
    
    private void prob(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        if (target < 0) 
            return;
        
        for(int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            prob(res, tmp, candidates, i + 1, target - candidates[i]);
            tmp.remove(tmp.size() - 1);
            
            while(i < candidates.length - 1 && candidates[i] == candidates[i + 1])
                i++;
        }
    }
    
    
    
    /**
     * LC216. Combination Sum III;
     * 
     * only numbers from 1 to 9;
     * k numbers add up to n;
     * 
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        
        if (k > 9 || n < 0 || n > k * 9)
            return res;
        
        prob(res, tmp, 9, n, k);
        
        return res;
    }
    
    private void prob(List<List<Integer>> res, List<Integer> tmp, int start, int target, int num) {
        if (target == 0 && num == 0) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        if (target < 0 || num <= 0) 
            return;
        
        for(int i = start; i > 0; i--) {
            tmp.add(i);
            prob(res, tmp, i - 1, target - i, num - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}

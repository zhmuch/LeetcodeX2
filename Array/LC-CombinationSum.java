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
}

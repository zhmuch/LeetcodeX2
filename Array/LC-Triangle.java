public class Solution {
    
    /**
     * 118. Pascal's Triangle
     * 
     */ 
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows < 1)
            return res;
        
        List<Integer> tmp = new LinkedList<>();
        tmp.add(1);
        res.add(tmp);
        if (numRows == 1)
            return res;
            
        tmp = new LinkedList<>();
        tmp.add(1);
        tmp.add(1);
        res.add(tmp);
        if (numRows == 2)
            return res;
        
        int left = 0, right = 1;
        for (int i = 2; i < numRows; i++) {            
            List<Integer> last = res.get(res.size() - 1);

            tmp = new LinkedList<>();
            tmp.add(1);
            for (int j = left; j < right; j++)
                tmp.add(last.get(j) + last.get(j + 1));
            tmp.add(1);
            res.add(tmp);
            
            right++;
        }
        
        return res;
    }
    
    
    
    /**
     * 119. Pascal's Triangle II
     * 
     */
    
}

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
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new LinkedList<>(), prev = new LinkedList<>();
        if (rowIndex < 0)
            return curr;
        
        curr.add(1);
        if (rowIndex == 0)
            return curr;
            
        curr.add(1);
        if (rowIndex == 1)
            return curr;
        
        List<Integer> tmp;
        
        for (int i = 1; i < rowIndex; i++) {   
            tmp = curr;
            curr = prev;
            prev = tmp;
            curr.clear();
            
            curr.add(1);
            for (int j = 0; j < prev.size() - 1; j++)
                curr.add(prev.get(j) + prev.get(j + 1));
            curr.add(1);
        }
        
        return curr;
    }
    
    
    /**
     * LC120. Triangle
     * 
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] prev = new int[row], curr = new int[row];
        curr[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < row; i++) {
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
            
            List<Integer> currRow = triangle.get(i);
            
            curr[0] = prev[0] + currRow.get(0);
            curr[i] = prev[i - 1] + currRow.get(i);
            for (int j = 1; j < i; j++) {
                curr[j] = currRow.get(j) + Math.min(prev[j - 1], prev[j]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < row; j++)
            min = Math.min(min, curr[j]);
        
        return min;
    }
}

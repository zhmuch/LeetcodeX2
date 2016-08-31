public class Solution {
    
    /**
     * LC064. Minimum Path Sum
     * 
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] prev = new int[col], curr = new int[col];
        
        prev[0] = grid[0][0];
        for (int j = 1; j < col; j++) 
            prev[j] = prev[j - 1] + grid[0][j];
            
        for (int i = 1; i < row; i++) {
            curr[0] = prev[0] + grid[i][0];
            for (int j = 1; j < col; j++)
                curr[j] = Math.min(curr[j - 1], prev[j]) + grid[i][j];
                
            int[] tmp = curr;
            curr = prev;
            prev = tmp;
        }
        
        return prev[col - 1];
    }
}

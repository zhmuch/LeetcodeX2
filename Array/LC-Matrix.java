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
    
    
    /**
     * LC073. Set Matrix Zeroes
     * 
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean firstRow = false;
        
        //  Search for 0;
        for (int j = 0; j < col; j++)
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
    
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    
                    if (i != 0)
                        matrix[i][0] = 0;
                }
        
        //  Set 0;
        for (int j = 1; j < col; j++)
            if (matrix[0][j] == 0)
                for (int i = 0; i < row; i++)
                    matrix[i][j] = 0;
        
        for (int i = 1; i < row; i++)
            if (matrix[i][0] == 0)
                for (int j = 0; j < col; j++)
                    matrix[i][j] = 0;
        
        if (matrix[0][0] == 0)
            for (int i = 0; i < row; i++)
                    matrix[i][0] = 0;
        
        if (firstRow)
            for (int j = 0; j < col; j++)
                    matrix[0][j] = 0;
    
        return;
    }
    
    
    /**
     * LC074. Search a 2D Matrix
     * 
     */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int start = 0, rows = matrix.length, cols = matrix[0].length;
            int end = rows * cols - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[mid / cols][mid % cols] == target) {
                    return true;
                } 
                if (matrix[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
     
     
     
    /**
     * LC240. Search a 2D Matrix II
     * 
     */ 
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        
        int r = 0, c =col - 1;
        while (r < row && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                c--;
            else 
                r++;
        }
        
        return false;
    }
}

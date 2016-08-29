public class Solution {

    /**
     * LC062. Unique Paths
     *
     */
    public int uniquePaths(int m, int n) {
        int mn = Math.min(m, n) - 1;
        long down = 1, up = 1;
        
        for(int i = 1; i <= mn; i++) {
            down *= i;
            up *= (m + n - 1 - i);
        }
        
        return (int)(up / down);
    }
    
    /**
     * LC063. Unique Paths II
     * 
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] paths = new int[row][col];
        
        if (obstacleGrid[0][0] == 1)
            return 0;
        
        paths[0][0] = 1;
        for (int j = 1; j < col; j++)
            if (obstacleGrid[0][j] == 1)
                break;
            else
                paths[0][j] = 1;
                
        for (int i = 1; i < row; i++) {
            paths[i][0] = (obstacleGrid[i][0] == 1) ? 0 : paths[i - 1][0];
            
            for (int j = 1; j < col; j++) 
                paths[i][j] = (obstacleGrid[i][j] == 1) ? 0 : paths[i - 1][j] + paths[i][j - 1];
        }        
        
        return paths[row - 1][col - 1];
    }
}

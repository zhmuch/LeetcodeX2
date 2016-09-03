public class Solution {
  /**
   * LC079. Word Search
   * 
   */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row < 1)
            return false;
        int col = board[0].length;
        
        if (word.length() < 1)
            return true;
        
        boolean[][] used = new boolean[row][col];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) 
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;
                    
                    if (dfs(board, used, directions, word, 1, i, j))
                        return true;
                    
                    used[i][j] = false;
                }
                
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] used, int[][] directions, String word, int idx, int x, int y) {
        if (idx >= word.length())
            return true;
            
        for (int d = 0; d < directions.length; d++) {
            int nx = x + directions[d][0];
            int ny = y + directions[d][1];
            
            if (nx >= 0 && nx < board.length && ny >=0 && ny < board[0].length && board[nx][ny] == word.charAt(idx) && !used[nx][ny]) {
                used[nx][ny] = true;
                
                if (dfs(board, used, directions, word, idx + 1, nx, ny))
                        return true;
                
                used[nx][ny] = false;
            }
            
        }
        
        return false;
    }
}

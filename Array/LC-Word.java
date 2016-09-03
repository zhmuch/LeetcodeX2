public class Solution {
  /**
   * LC079. Word Search
   * 
   * O(n) space
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
    
    
    
    /**
     * LC079. Word Search
     * 
     * O(1) space
     * 
     */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
        	for (int x=0; x<board[y].length; x++) {
        		if (exist(board, y, x, w, 0)) return true;
        	}
        }
        return false;
    }
    
    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    	if (i == word.length) return true;
    	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    	if (board[y][x] != word[i]) return false;
    	board[y][x] ^= 256;
    	boolean exist = exist(board, y, x+1, word, i+1)
    		|| exist(board, y, x-1, word, i+1)
    		|| exist(board, y+1, x, word, i+1)
    		|| exist(board, y-1, x, word, i+1);
    	board[y][x] ^= 256;
    	return exist;
    }
}

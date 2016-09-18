public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length < 1)
            return;
            
        int row = board.length;
        int col = board[0].length;
        int[][] offset = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = getLives(board, offset, i, j);
            
                if (board[i][j] > 0) {
                    if (lives != 2 && lives != 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (lives == 3)
                        board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                if (board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
            
        return;
    }
    
    private int getLives(int[][] board, int[][] offset, int r, int c) {
        int row = board.length;
        int col = board[0].length;
        
        int lives = 0;
        for (int i = 0; i < offset.length; i++) {
            int tr = r + offset[i][0];
            int tc = c + offset[i][1];
            
            if (tr >= 0 && tr < row && tc >= 0 && tc < col) 
                lives += (board[tr][tc] == 1 || board[tr][tc] == 3) ? 1 : 0;
        }
        
        return lives;
    }
}

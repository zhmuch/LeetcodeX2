public class Solution {
    /**
     * 36. Valid Sudoku
     */
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        
        for (int i = 0; i < 9; i++)
            if (!isValid(board, i, 0, i, 8) || !isValid(board, 0, i, 8, i) || !isValid(board, (i / 3) * 3, (i % 3) * 3))
                return false;
        
        return true;
    }
    
    private boolean isValid(char[][] board, int r, int c) {
        boolean[] used = new boolean[9];
        
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board[i][j] == '.')
                    continue;
                else if (used[board[i][j] - '1'])
                    return false;
                else
                    used[board[i][j] - '1'] = true;
        
        return true;
    }
    
    private boolean isValid(char[][] board, int r1, int c1, int r2, int c2) {
        boolean[] used = new boolean[9];
        
        if (r1 == r2) {
            for (int i = c1; i <= c2; i++)
                if (board[r1][i] == '.')
                    continue;
                else if (used[board[r1][i] - '1'])
                    return false;
                else
                    used[board[r1][i] - '1'] = true;
        } else {
            for (int i = r1; i <= r2; i++)
                if (board[i][c1] == '.')
                    continue;
                else if (used[board[i][c1] - '1'])
                    return false;
                else
                    used[board[i][c1] - '1'] = true;
        }
        
        return true;
    }
}

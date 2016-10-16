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
    
    /**
     * 36. Valid Sudoku
     * Encode as a String;
     */
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
    
    /** 
     *  37. Sudoku Solver
     */
    public class Solution {
        public void solveSudoku(char[][] board) {
            // There are 27 sets
            // 0..8:    row
            // 9..17:   col
            // 18..26:  block

            Hashtable<Integer, Set<Integer>> table = new Hashtable<>();
            for (int i = 0; i < 27; i++)
                table.put(i, new HashSet<Integer>());

            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    if (board[i][j] == '.')
                        continue;
                    else {
                        int t = board[i][j] - '0';
                        table.get(i).add(t);
                        table.get(9 + j).add(t);
                        table.get((i / 3) * 3 + (j / 3) + 18).add(t);
                    }

            solver(board, table, 0, 0);
        }

        private boolean solver(char[][] board, Hashtable<Integer, Set<Integer>> table, int r, int c) {

            if (r >= 9)
                return true;

            if (c >= 9)
                return solver(board, table, r + 1, 0);

            if (board[r][c] != '.')
                return solver(board, table, r, c + 1);

            for (int i = 1; i <= 9; i++) {

                if (!table.get(r).contains(i) && !table.get(9 + c).contains(i) &&
                        !table.get((r / 3) * 3 + (c / 3) + 18).contains(i)) {
                    
                    table.get(r).add(i);
                    table.get(9 + c).add(i);
                    table.get((r / 3) * 3 + (c / 3) + 18).add(i);
                    board[r][c] = (char)('0' + i);

                    if (solver(board, table, r, c + 1))
                        return true;

                    table.get(r).remove(i);
                    table.get(9 + c).remove(i);
                    table.get((r / 3) * 3 + (c / 3) + 18).remove(i);
                    board[r][c] = '.';
                }
            }

            return false;
        }

    }
}

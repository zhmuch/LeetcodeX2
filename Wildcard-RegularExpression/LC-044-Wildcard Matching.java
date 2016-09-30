public class Solution {
    
    /**
     * DP
     * O(N^2)
     *
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
            
        boolean[][] mat = new boolean[p.length() + 1][s.length() + 1];
        mat[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            mat[i][0] = mat[i - 1][0] && p.charAt(i - 1) == '*';
            boolean isPre = mat[i - 1][0];
            
            for (int j = 1; j <= s.length(); j++) {
                isPre = isPre || mat[i - 1][j];                 //Does last pattern character match any position;
                
                if (p.charAt(i - 1) == '*') {
                    mat[i][j] = isPre;
                } else if (p.charAt(i - 1) == '?') {
                    mat[i][j] = mat[i - 1][j - 1];
                } else {
                    mat[i][j] = mat[i - 1][j - 1] && p.charAt(i - 1) == s.charAt(j - 1);
                }
            }
        }
    
        return mat[p.length()][s.length()];
    }
}

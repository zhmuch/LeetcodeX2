public class Solution {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        int[] cut = new int[len];
        
        for (int i = 0; i < len; i++) {
            mat[i][i] = true;
            cut[i] = Integer.MAX_VALUE;
        }
        
        for (int j = 1; j < len; j++) {
            for (int i = 0; i + j < len; i++) {
                mat[i][i + j] = (j == 1) ? (s.charAt(i) == s.charAt(i + j)) : (mat[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j));
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (mat[0][i]) {
                cut[i] = 0;
                continue;
            }
            
            for (int j = i; j > 0; j--) {
                if (mat[j][i])
                    cut[i] = Math.min(cut[i], cut[j - 1] + 1);
            }
        }
    
        return cut[len - 1];
    }
}

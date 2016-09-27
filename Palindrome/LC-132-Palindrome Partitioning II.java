public class Solution {
    /** 
     *优化版
     */
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
    
    
    /**
     * 稍慢
     */
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

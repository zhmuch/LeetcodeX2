public class Solution {
    /**
     * Greedy + Search
     * 用两个指针save_i, save_j代替递归
     */
    public boolean isMatch(String s, String p) {
        char p_ar[] = p.toCharArray();
        char s_ar[] = s.toCharArray();
        int save_i, save_j, i, j;
        save_i = save_j = -1;
        i = j = 0;
        while(i < s_ar.length){
            if(j < p_ar.length && (s_ar[i] == p_ar[j] || p_ar[j] == '?')){
                ++i;
                ++j;
            }else if(j < p_ar.length && p_ar[j] == '*'){
                save_i = i + 1;
                save_j = j;
                ++j;
            }else if(save_i != -1){
                i = save_i;
                j = save_j;
            }else return false;
        }
        while(j < p_ar.length)if(p_ar[j++] != '*')return false;
        return i == s_ar.length && j == p_ar.length;
    }
    
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

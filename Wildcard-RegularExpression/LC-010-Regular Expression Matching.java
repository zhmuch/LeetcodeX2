public class Solution {
    
    /**
     * DP
     */
    public boolean isMatch(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        
        if(lp == 0)
            return ls == 0;

        boolean[] isPre = new boolean[lp];
        for(int i = 1; i < lp; i++)
            if(p.charAt(i) == '*')
                isPre[i] = ! isPre[i - 1];

        boolean[][] mat = new boolean[lp][ls+1];
        
        //First Line.
        if(ls != 0){
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                mat[0][1] = true;
        }
        
        for(int i=1; i<lp; i++) {
            if(isPre[i]) {
                if (i == 1){
                    mat[i][0] = true;
                    for (int j = 0; j < ls; j++) {
                        if( (p.charAt(0) == s.charAt(j) || p.charAt(0) == '.') && mat[1][j] )
                            mat[1][j+1] = true;
                        else
                            mat[1][j+1] = false;
                    }

                } else {
                    mat[i][0] = mat[i - 2][0];

                    for (int j = 0; j < ls; j++) {
                        if( ((p.charAt(i-1) == s.charAt(j) || p.charAt(i-1) == '.') && (mat[i-2][j] || mat[i][j])) 
                        || mat[i-2][j+1])
                            mat[i][j+1] = true;
                        else
                            mat[i][j+1] = false;
                    }
                }
            } else {
                mat[i][0] = false;
                for (int j = 0; j < ls; j++) {
                    if( (p.charAt(i) == s.charAt(j) || p.charAt(i) == '.' ) && mat[i-1][j] )
                        mat[i][j+1] = true;
                    else
                        mat[i][j+1] = false;
                }
            }
        }

        return mat[lp-1][ls];
    }
}

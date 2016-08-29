public class Solution {

    /**
     * LC062. Unique Paths
     *
     */
    public int uniquePaths(int m, int n) {
        int mn = Math.min(m, n) - 1;
        long down = 1, up = 1;
        
        for(int i = 1; i <= mn; i++) {
            down *= i;
            up *= (m + n - 1 - i);
        }
        
        return (int)(up / down);
    }
}

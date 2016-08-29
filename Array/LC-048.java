public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for (int p = 0; p < n / 2; p++) {
            /* corner point (p, p) */
            int edge = n - 2 * p;
            
            for (int offset = 0; offset < edge - 1; offset++) {
                int tmp = matrix[p][p + offset];
                
                /* anticlockwise move */
                matrix[p][p + offset] = matrix[n - p - 1 - offset][p];
                matrix[n - p - 1 - offset][p] = matrix[n - p - 1][n - p - 1 - offset];
                matrix[n - p - 1][n - p - 1 - offset] = matrix[p + offset][n - p - 1];
                matrix[p + offset][n - p - 1] = tmp;
            }
        }
        
        return;
    }
}

public class Solution {
    /**
     * LC048. Rotate Image
     * 
     */
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
    
    
    
    
    /**
     * LC054. Spiral Matrix
     * 
     * 
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();

        int row = matrix.length;
        if (row < 1) return result;
        int col = matrix[0].length;
        if (col < 1) return result;

        boolean[][] flag = new boolean[row][col];
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                flag[i][j] = true;
            }
        }

        int i = 0;
        int j = 0;
        int count = 0;
        int direction = 0;

        while (count < row * col){
            switch (direction)
            {
                case 0: {
                    while(j<col && flag[i][j]){
                        result.add(matrix[i][j]);
                        count++;
                        flag[i][j]=false;
                        j++;
                    }
                    j--;
                    i++;
                    direction = 1;
                    break;
                }
                case 1: {
                    while(i<row && flag[i][j]){
                        result.add(matrix[i][j]);
                        count++;
                        flag[i][j]=false;
                        i++;
                    }
                    i--;
                    j--;
                    direction = 2;
                    break;
                }
                case 2: {
                    while(j>=0 && flag[i][j]){
                        result.add(matrix[i][j]);
                        count++;
                        flag[i][j]=false;
                        j--;
                    }
                    j++;
                    i--;
                    direction = 3;
                    break;
                }
                case 3: {
                    while(i>=0 && flag[i][j]){
                        result.add(matrix[i][j]);
                        count++;
                        flag[i][j]=false;
                        i--;
                    }
                    i++;
                    j++;
                    direction = 0;
                    break;
                }
            }

        }
        return result;
    }
    
    
    
    /**
     * LC059. Spiral Matrix II
     * 
     */
    public int[][] generateMatrix(int n) {
        if (n<1) {
            int[][] result = new int[0][0];
            return result;
        }

        int[][] result = new int[n][n];

        boolean[][] flag = new boolean[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                flag[i][j] = true;
            }
        }

        int i = 0;
        int j = 0;
        int count = 1;
        int direction = 0;

        while (count <= n * n){
            switch (direction)
            {
                case 0: {
                    while(j<n && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        j++;
                    }
                    j--;
                    i++;
                    direction = 1;
                    break;
                }
                case 1: {
                    while(i<n && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        i++;
                    }
                    i--;
                    j--;
                    direction = 2;
                    break;
                }
                case 2: {
                    while(j>=0 && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        j--;
                    }
                    j++;
                    i--;
                    direction = 3;
                    break;
                }
                case 3: {
                    while(i>=0 && flag[i][j]){
                        result[i][j] = count;
                        count++;
                        flag[i][j]=false;
                        i--;
                    }
                    i++;
                    j++;
                    direction = 0;
                    break;
                }
            }

        }
        return result;
    }

}

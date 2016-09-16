public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length < 1)
            return 0;
        
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            int curr = 0;
            
            for (int j = 0; j < A.length; j++) {
                curr += j * A[(j - i + A.length) % A.length];
            }
            
            max = Math.max(max, curr);
        }
        
        return max;
    }
}

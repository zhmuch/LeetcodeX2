public class Solution {
    public double myPow(double x, int n) {
        
        //  whether n is negative;
        boolean isDiv = (n < 0);
        
        n = Math.abs(n);
        double res = 1.0;
        int pos = 0;
        
        while (n != 0) {
            
            if ((n & 1) == 1) 
                res *= x;
            
            n >>>= 1;
            pos++;
            x *= x;
        }
        
        return (isDiv) ? 1.0 / res : res;
    }
}

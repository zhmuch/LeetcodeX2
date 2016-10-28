/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {  
        if( buf==null || n<=0) 
            return 0;  
        
        int i=0;  
        char[] temp = new char[4];  
        while (n > 0) {  
            int x = read4(temp);  
            int j = 0;  
            int k = x;  
            while (n > 0 && x > 0) {  
                buf[i++] = temp[j++];  
                --x;  
                --n;  
            }  
            if(k<4) break;  
        }  
        return i;  
    }  
}

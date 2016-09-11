public class Solution {
  
    public int lengthOfLastWord(String s) {
        int len = 0, prev = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (len != 0)
                    prev = len;
                len = 0;
            }
            else {
                len++;
            }
        }
        
        
        return (len == 0) ? Math.max(prev, len) : len;
    }
}

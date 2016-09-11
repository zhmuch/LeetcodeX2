public class Solution {
    /**
     * LC-058. Length of Last Word
     * 
     * 
     */
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
    
    
    /**
     * LC-151. Reverse Words in a String
     * 
     * 
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        int idx = 0, start = -1, end = -1;
        while (idx < len) {
            while (idx < len && s.charAt(idx) == ' ')
                idx++;

            start = idx;
            while (idx < len && s.charAt(idx) != ' ')
                idx++;
            end = idx - 1;

            for (; start <= end; end--) {
                sb.insert(0, s.charAt(end));
            }

            if (idx == len)
                break;
            else
                sb.insert(0, ' ');
        }

        if (sb.length() > 0 && sb.charAt(0) == ' ')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}

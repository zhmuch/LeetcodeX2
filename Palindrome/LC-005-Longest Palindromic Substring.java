public class Solution {

    /**
     * Expand from center;
     *
     * Better running time;
     */
    public class Solution {
        private int lo, maxLen;

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;

            for (int i = 0; i < len-1; i++) {
                extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
                extendPalindrome(s, i, i+1); //assume even length.
            }
            return s.substring(lo, lo + maxLen);
        }

        private void extendPalindrome(String s, int j, int k) {
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (maxLen < k - j - 1) {
                lo = j + 1;
                maxLen = k - j - 1;
            }
        }
    }
    
   
    /**
     * Poor Performance;
     *
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        
        for (int i = len; i >= 0; i--) {
            int left, right;
            for (left = 0; ; left++) {
                right = left + i - 1;
                if (right >= len)
                    break;
                if (isPalin(s, left, right)) {
                    res = s.substring(left, right + 1);
                    return res;
                }
            }
        }
        
        return res;
    }
    
    boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}

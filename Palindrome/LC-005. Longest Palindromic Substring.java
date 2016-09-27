public class Solution {


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

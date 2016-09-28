public class Solution {

    /**
     * Naive;
     * O(N^2)
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        
        if (len < 2)
            return s;
            
        int right = len - 1;
        while(right != 0) {
            if (isPalin(s, 0, right)) {
                break;
            }
            right--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = len - 1; i > right; i--)
            sb.append(s.charAt(i));
        sb.append(s);
        
        return sb.toString();
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

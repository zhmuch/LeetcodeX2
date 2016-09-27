public class Solution {
    public boolean isPalindrome(String s) {
        String tmp = s.toLowerCase();
        
        int left = 0, right = tmp.length() - 1;
        
        while (left < right) {
            if (!isConsider(tmp.charAt(left))) {
                left++;
            } else if (!isConsider(tmp.charAt(right))) {
                right--;
            } else {
                if (tmp.charAt(left) != tmp.charAt(right))
                    return false;
                left++;
                right--;
            }
        }
        
        return true;
    }
    
    boolean isConsider(char c) {
        return (0 <= c - 'a' && c - 'a' <= 25) || (0 <= c - '0' && c - '0' <= 9);
    }
}

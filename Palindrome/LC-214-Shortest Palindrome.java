public class Solution {
    
    /**
     * KMP
     */
    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        
        char[] str = s.toCharArray();
        int[] helper = new int[str.length + 1];

        prefixComp(helper, str);

        int matched = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            while (matched > 0 && str[matched] != str[i])
                matched = helper[matched];

            if (str[matched] == str[i])
                matched++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= matched; i--)
            sb.append(str[i]);
        sb.append(s);

        return sb.toString();
    }

    private void prefixComp(int[] helper, char[] str) {
        int len = helper.length;

        helper[1] = 0;
        int matched = 0;
        for (int i = 2; i < len; i++) {
            while (matched > 0 && str[matched] != str[i - 1])
                matched = helper[matched];

            if (str[matched] == str[i - 1])
                matched++;

            helper[i] = matched;
        }

        return;
    }

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

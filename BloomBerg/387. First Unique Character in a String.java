public class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int c = getInt(s.charAt(i));
            
            if (c == -1)
                continue;
            else {
                if (arr[c] == 0)
                    arr[c] = i + 1;
                else
                    arr[c] = -1;
            }
        }
        
        //  find the smallest index;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) 
            if (arr[i] > 0)
                res = Math.min(res, arr[i] - 1);
        
        return (res == Integer.MAX_VALUE) ? -1 : res;
        
    }
    
    private int getInt(char c) {
        int res = c - 'a';
    
        return (res >= 0 && res < 26) ? res : -1;
    }
}

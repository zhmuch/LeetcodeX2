public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }
        
        return set.size() < 2;
    }
}

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
    
    
    /**
     * LC290. Word Pattern
     * 
     * 
     */
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        if (pattern.length() != words.length)
            return false;
            
        
        Hashtable<Character, String> table = new Hashtable<>();
        int stringCount = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (table.containsKey(pattern.charAt(i))) {
                if (!table.get(pattern.charAt(i)).equals(words[i]))
                    return false;
            } else {
                if (!table.contains(words[i]))
                    stringCount++;
                table.put(pattern.charAt(i), words[i]);
            }
        }
        
        return stringCount == table.size();
    }
    
    
    /**
     * LC318. Maximum Product of Word Lengths
     * 
     * 
     */
    public int maxProduct(String[] words) {
        int[] map = new int[words.length];

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            int bits = 0;
            for (int j = 0; j < words[i].length(); j++) {
                bits = bits | (1 << words[i].charAt(j));
            }
            map[i] = bits;
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() * words[i].length() <= max)
                break;
            for (int j = i + 1; j < words.length; j++) {
                if ((map[i] & map[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                    break;
                }
            }
        }

        return max;
    }
    
    
    /**
     * LC030. Substring with Concatenation of All Words
     * 
     * Naive Search;
     * 
     */
    public static List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }
    
    
    /**
     * LC076. Minimum Window Substring
     * 
     * 80ms;
     * 
     */
    public String minWindow(String s, String t) {
        int l = 0, r = -1, len = Integer.MAX_VALUE;

        if (s.length() < t.length())
            return "";

        //  Special case: t has only one character;
        if (t.length() == 1) {
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == t.charAt(0))
                    return new String(t);
            return "";
        }

        //  Construct dictionary for t;
        int[] charDict = new int[128];
        int unmatched = 0;
        for (int i = 0; i < t.length(); i++) {
            int p = (int) t.charAt(i);
            if (charDict[p] == 0)
                unmatched++;
            charDict[p]++;
        }


        int[] curr = new int[128];
        int left = 0, right = -1;

        while (true) {

            while (unmatched > 0 && right < s.length() - 1) {
                right++;
                int p = (int) s.charAt(right);

                if (charDict[p] > 0) {
                    curr[p]++;
                    if (charDict[p] == curr[p])
                        unmatched--;
                }
            }

//            System.out.println("Unmatched: " + unmatched + "  left: " + left + "  right: " + right);

            while (unmatched == 0 && left < right) {
                int p = (int) s.charAt(left);
                left++;

                if (charDict[p] > 0) {
                    if (charDict[p] == curr[p]) {
                        unmatched++;

                        //  All matched decide if minimum;
                        left--;
                        if (right - left < len) {
                            l = left;
                            r = right;
                            len = right - left;
                        }
                        left++;
                    }
                    curr[p]--;
                }
            }

            while (unmatched == 1 && left < right) {
                int p = (int) s.charAt(left);

                if (charDict[p] > 0) {
                    if (charDict[p] >= curr[p])
                        break;
                    curr[p]--;
                }

                left++;
            }

            if (left > right || right >= s.length() - 1)
                break;
        }

        return s.substring(l, r + 1);
    }
}

import java.io.*;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length < 1)
            return "";

        //  Build graph
        Set<Character> dict = new HashSet<>();
        Set<Character> used = new HashSet<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (c - 'a' < 0 || c - 'a' > 25)
                    return "";
                else
                    dict.add(c);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int len = Math.min(words[i].length(), words[i + 1].length());
            int j = 0;

            for (; j < len; j++) {
                char p = words[i].charAt(j);
                char n = words[i + 1].charAt(j);
                if (p != n) {
                    if (map.containsKey(p))
                        map.get(p).add(n);
                    else {
                        Set<Character> newSet = new HashSet<>();
                        newSet.add(n);
                        map.put(p, newSet);
                    }
                    break;
                }
            }
            
            if (j == len && words[i].length() > words[i + 1].length())
                return "";
        }

        //  Topology Sort
        while (true) {
            if (dict.isEmpty())
                break;

            char curr = dict.iterator().next();
            if (!dfs(dict, used, map, curr, sb))
                return "";
                
        }

        return sb.toString();
    }

    private boolean dfs(Set<Character> dict, Set<Character> used, Map<Character, Set<Character>> map, char curr, StringBuilder sb) {
        if (!dict.contains(curr))
            return used.contains(curr);

        dict.remove(curr);

        if (map.containsKey(curr)) {
            for (char c : map.get(curr)) {
                if (!dfs(dict, used, map, c, sb))
                    return false;
            }
        }

        used.add(curr);
        sb.insert(0, curr);

        return true;
    }
}

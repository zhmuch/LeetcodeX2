public class Solution {
  /**
   * LC079. Word Search
   * 
   * O(n) space
   * 
   */
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row < 1)
            return false;
        int col = board[0].length;
        
        if (word.length() < 1)
            return true;
        
        boolean[][] used = new boolean[row][col];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) 
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;
                    
                    if (dfs(board, used, directions, word, 1, i, j))
                        return true;
                    
                    used[i][j] = false;
                }
                
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] used, int[][] directions, String word, int idx, int x, int y) {
        if (idx >= word.length())
            return true;
            
        for (int d = 0; d < directions.length; d++) {
            int nx = x + directions[d][0];
            int ny = y + directions[d][1];
            
            if (nx >= 0 && nx < board.length && ny >=0 && ny < board[0].length && board[nx][ny] == word.charAt(idx) && !used[nx][ny]) {
                used[nx][ny] = true;
                
                if (dfs(board, used, directions, word, idx + 1, nx, ny))
                        return true;
                
                used[nx][ny] = false;
            }
            
        }
        
        return false;
    }
    
    
    
    /**
     * LC079. Word Search
     * 
     * O(1) space
     * 
     */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y=0; y<board.length; y++) {
        	for (int x=0; x<board[y].length; x++) {
        		if (exist(board, y, x, w, 0)) return true;
        	}
        }
        return false;
    }
    
    private boolean exist(char[][] board, int y, int x, char[] word, int i) {
    	if (i == word.length) return true;
    	if (y<0 || x<0 || y == board.length || x == board[y].length) return false;
    	if (board[y][x] != word[i]) return false;
    	board[y][x] ^= 256;
    	boolean exist = exist(board, y, x+1, word, i+1)
    		|| exist(board, y, x-1, word, i+1)
    		|| exist(board, y+1, x, word, i+1)
    		|| exist(board, y-1, x, word, i+1);
    	board[y][x] ^= 256;
    	return exist;
    }
    
    
    
    /**
     * 127. Word Ladder
     * 
     * Time Limit Exceed;
     * 
     */
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        int dist = 1, len = beginWord.length();

        if (beginWord.equals(endWord))
            return dist;

        Set<String> used = new HashSet<>();
        Set<String> left = new HashSet<>(wordList);
        Set<String> curr = new HashSet<>();
        Set<String> prev;

        used.add(beginWord);
        curr.add(beginWord);

        while(true) {
            prev = curr;
            curr = new HashSet<>();

            for (String s : prev) {
                StringBuilder tmp = new StringBuilder(s);
                for (int i = 0; i < len; i++) {
                    char c = tmp.charAt(i);
                    tmp.deleteCharAt(i);

                    for (int j = 0; j < 26; j++) {
                        char replace = (char)('a' + j);
                        tmp.insert(i, replace);

                        String newAdd = tmp.toString();

                        if (endWord.equals(newAdd)) {
                            dist++;
                            return dist;
                        }

                        if (left.contains(newAdd)){

                            used.add(newAdd);
                            left.remove(newAdd);
                            curr.add(newAdd);
                        }

                        tmp.deleteCharAt(i);
                    }

                    tmp.insert(i, c);
                }
            }

            dist++;

            if (curr.isEmpty()) {
                return 0;
            }
        }
    }
    
    
    
    /**
     * 126. Word Ladder II
     * 
     * Two End BFS;
     * 
     */
        public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        
        // initial words in both ends
        set1.add(start);
        set2.add(end);
        
        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        // build the map
        helper(dict, set1, set2, map, false);
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>(Arrays.asList(start));
        
        // recursively build the final result
        generateList(start, end, map, sol, res);
        
        return res;
      }
  
    boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
          return false;
        }
    
        if (set1.size() > set2.size()) {
          return helper(dict, set2, set1, map, !flip);
        }
        
        // remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);
        
        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;
        
        // set for the next level
        Set<String> set = new HashSet<String>();
        
        // for each string in end 1
        for (String str : set1) {
          for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray();
            
            // change one character for every position
            for (char ch = 'a'; ch <= 'z'; ch++) {
              chars[i] = ch;
              
              String word = new String(chars);
              
              // make sure we construct the tree in the correct direction
              String key = flip ? word : str;
              String val = flip ? str : word;
                  
              List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
                  
              if (set2.contains(word)) {
                done = true;
                
                list.add(val);
                map.put(key, list);
              } 
              
              if (!done && dict.contains(word)) {
                set.add(word);
                
                list.add(val);
                map.put(key, list);
              }
            }
          }
        }
    
        // early terminate if done is true
        return done || helper(dict, set2, set, map, !flip);
    }
  
      void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
          res.add(new ArrayList<String>(sol));
          return;
        }
        
        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
          return;
        }
        
        for (String word : map.get(start)) {
          sol.add(word);
          generateList(word, end, map, sol, res);
          sol.remove(sol.size() - 1);
        }
      }
      
    /**
     * 139. Word Break
     * 
     * DP, little pruning;
     * 
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] mat = new boolean[len + 1];
        mat[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (mat[j]) {
                    String tmp = s.substring(j, i);
                    if (wordDict.contains(tmp)) {
                        mat[i] = true;
                        break;
                    }
                }
            }
        }
        
        return mat[len];
    }
    
    
  /**
   * 140. Word Break II
   * 
   * AC, 27ms
   * 
   */
  public List<String> wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        Hashtable<Integer, List<Integer>> father = new Hashtable<>();
        father.put(0, new LinkedList<>());
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (father.containsKey(j)) {
                    String tmp = s.substring(j, i);
                    if (wordDict.contains(tmp)) {
                        if (father.containsKey(i)) {
                            father.get(i).add(j);
                        } else {
                            father.put(i, new LinkedList<Integer>(Arrays.asList(j)));
                        }
                    }
                }
            }
        }
        
        List<String> res = new LinkedList<>();
        if (!father.containsKey(len))
            return res;
        
        dfs(res, father, s, new StringBuilder(), len);
        
        return res;
    }
    
    private void dfs(List<String> res, Hashtable<Integer, List<Integer>> father, String s, StringBuilder sb, int idx) {
        if (idx == 0) {
            res.add(sb.toString());
        }
        
        for (int i : father.get(idx)) {
            StringBuilder newSb = new StringBuilder(sb);
            
            if (newSb.length() > 0) {
                newSb.insert(0, ' ');
            }
            
            for (int j = idx - 1; j >= i; j--) {
                newSb.insert(0, s.charAt(j));
            }
            
            dfs(res, father, s, newSb, i);
        }
        
        return;
    }
}

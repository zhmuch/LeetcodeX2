public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] mat = new boolean[len][len];
        
        for (int i = 0; i < len; i++)
            mat[i][i] = true;
        
        for (int j = 1; j < len; j++) {
            for (int i = 0; i + j < len; i++) {
                mat[i][i + j] = (j == 1) ? (s.charAt(i) == s.charAt(i + j)) : (mat[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j));
            }
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(mat[i][j] + " ");
            }
            
            System.out.println();
        }
        
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> tmp = new LinkedList<>();
        
        dfs(s, mat, res, tmp, 0);
        
        return res;
    }
    
    private void dfs(String s, boolean[][] mat, List<List<String>> res, LinkedList<String> tmp, int idx) {
        int len = s.length();
        
        if (idx >= len) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        
        for (int i = idx; i < len; i++) {
            if (mat[idx][i]) {
                tmp.add(s.substring(idx, i + 1));
                
                dfs(s, mat, res, tmp, i + 1);
                
                tmp.removeLast();
            }
        }
        
        return;
    }
}

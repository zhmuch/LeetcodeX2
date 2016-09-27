public class Solution {
    /**
     * Much Faster;
     *
     */
    	public class Solution {
            List<List<String>> resultLst;
	    ArrayList<String> currLst;
        
	    public List<List<String>> partition(String s) {
	        resultLst = new ArrayList<List<String>>();
	        currLst = new ArrayList<String>();
	        backTrack(s,0);
	        return resultLst;
	    }
        
	    public void backTrack(String s, int l){
	        if(currLst.size()>0 //the initial str could be palindrome
	            && l>=s.length()){
	                List<String> r = (ArrayList<String>) currLst.clone();
	                resultLst.add(r);
	        }
	        for(int i=l;i<s.length();i++){
	            if(isPalindrome(s,l,i)){
	                if(l==i)
	                    currLst.add(Character.toString(s.charAt(i)));
	                else
	                    currLst.add(s.substring(l,i+1));
	                backTrack(s,i+1);
	                currLst.remove(currLst.size()-1);
	            }
	        }
	    }
        
	    public boolean isPalindrome(String str, int l, int r){
	        if(l==r) return true;
	        while(l<r){
	            if(str.charAt(l)!=str.charAt(r)) return false;
	            l++;r--;
	        }
	        return true;
	    }
    	}
    
    
    /**
     * DP + Backtrack;
     *
     */
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

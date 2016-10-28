public class Solution {

    /**
     * Comparator #1
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        
        for (int i = 1; i <= n; i++)
            res.add(i);
        
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = Integer.toString(o1);
                String s2 = Integer.toString(o2);
                
                int idx = 0;
                while(idx < s1.length() && idx < s2.length()) {
                    if (s1.charAt(idx) - s2.charAt(idx) > 0)
                        return 1;
                    if (s1.charAt(idx) - s2.charAt(idx) < 0)
                        return -1;
                    idx++;
                }
                
                if (idx == s1.length())
                    return -1;
                else 
                    return 1;
            }
        });
        
        return res;
    }
}

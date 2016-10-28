public class Solution {
    /**
     * Other`s Elegant
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
    
    /**
     * Generate 
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        int curr = 1;

        for (int i = 0; i < n; i++) {
            res.add(curr);

            //  possible 1
            if (curr * 10 <= n) {
                curr *= 10;
                continue;
            }

            //  possible 2
            while (curr % 10 == 9)
                curr /= 10;

            if (curr + 1 > n)
                curr /= 10;
            else {
                curr++;
                continue;
            }

            while (curr % 10 == 9)
                curr /= 10;
            
            curr++;
        }

        return res;
    }

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
    
    
    /**
     * Comparator #2
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            res.add(i);

        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int l1 = Integer.toString(o1).length();
                int l2 = Integer.toString(o2).length();

                while (l1 > l2) {
                    o2 *= 10;
                    l2++;
                }

                while (l2 > l1) {
                    o1 *= 10;
                    l1++;
                }

                return o1 - o2;
            }
        });

        return res;
    }
}

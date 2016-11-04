import java.util.*;

public class Solution {

    /**
     * Poor Performance;
     */
    class CharNode {
        char charVal;
        int count;
        int nextAvailable;
    }

    public String rearrangeString(String str, int k) {

        char[] chars = str.toCharArray();
        Hashtable<Character, CharNode> count = new Hashtable<>();
        PriorityQueue<CharNode> heap = new PriorityQueue<>((a,b) -> (b.count - a.count));

        for (char c : chars) {
            if (count.containsKey(c)) {
                count.get(c).count++;

            } else {
                CharNode cn = new CharNode();
                cn.charVal = c;
                cn.count = 1;
                cn.nextAvailable = 0;

                count.put(c, cn);
            }
        }

        for (char c : count.keySet())
            heap.add(count.get(c));

        //

        StringBuilder res = new StringBuilder();
        Set<CharNode> tmp = new HashSet<>();

        for (int i = 0; i < chars.length; i++) {
            while (true) {

                if (heap.size() == 0)
                    return "";

                CharNode head = heap.poll();
                
                if (head.nextAvailable <= i) {
                    res.append(head.charVal);

                    head.count--;
                    head.nextAvailable = i + k;

                    if (head.count > 0)
                        heap.add(head);

                    break;
                } else {
                    tmp.add(head);
                }

            }

            if (tmp.size() > 0)
                for (CharNode cn : tmp)
                    heap.add(cn);
        }

        return res.toString();
    }
}

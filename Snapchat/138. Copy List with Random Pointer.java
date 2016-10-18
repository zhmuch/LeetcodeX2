import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;


        RandomListNode probe = head;
        int idx = 0;
        Hashtable<RandomListNode, Integer> table = new Hashtable<>();

        while (probe != null) {
            table.put(probe, idx);

            probe = probe.next;
            idx++;
        }

        //  copy value
        RandomListNode res = new RandomListNode(head.label);
        RandomListNode probeNew = res;
        probe = head.next;

        Hashtable<Integer, RandomListNode> tableNew = new Hashtable<>();
        tableNew.put(0, res);

        for (int i = 1; i < idx; i++) {
            probeNew.next = new RandomListNode(probe.label);
            probeNew = probeNew.next;
            probe = probe.next;

            tableNew.put(i, probeNew);
        }

        //  copy random pointer
        probe = head;
        probeNew = res;

        for (int i = 0; i < idx; i++) {
            if (probe.random == null)
                probeNew.random = null;
            else {
                int rand = table.get(probe.random);
                probeNew.random = tableNew.get(rand);
            }

            probe = probe.next;
            probeNew = probeNew.next;
        }


        return res;
    }
}

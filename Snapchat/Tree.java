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

    /**
     * 270. Closest Binary Search Tree Value
     *  Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
     *
     */
    public int closestValue(TreeNode root, double target) {
        
        int can;
        if (root.val > target) {
            if (root.left == null)
                return root.val;
            can = closestValue(root.left, target);
        } else {
            if (root.right == null)
                return root.val;
            can = closestValue(root.right, target);
        }
        

        return (dif(target, can) > dif(target, root.val)) ? root.val : can;
    }

    private double dif(double target, int i) {
        return Math.abs(target - (double)i);
    }
}

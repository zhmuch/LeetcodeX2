/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/**
 * 339. Nested List Weight Sum
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.size() < 1)
            return 0;
        
        int sum = 0;
        
        for (NestedInteger i : nestedList) {
            sum += (i.isInteger()) ? i.getInteger() * depth : depthSum(i.getList(), depth + 1);
        }
        
        return sum;
    }
}

/**
 * 364. Nested List Weight Sum II
 * Wrong but make sense;
 * all node without children is leaves;
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return depthSumInverse(nestedList, 0)[0];
    }
    
    /**
     * [0]: sum;
     * [1]: root depth;
     */
    public int[] depthSumInverse(List<NestedInteger> nestedList, int nothing) {
        int[] res = new int[2];
        
        if (nestedList == null || nestedList.size() < 1) {
            res[0] = 0;
            res[1] = 1;
            return res;
        }
    
        int depth = 1, sum = 0, currSum = 0;
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                currSum += i.getInteger();
            } else {
                int[] tmp = depthSumInverse(i.getList(), 0);
                sum += tmp[0];
                depth = Math.max(depth, tmp[1]);
            }
        }
        
        sum += currSum * depth;
        
        res[0] = sum;
        res[1] = depth + 1;
        return res;
    }
}

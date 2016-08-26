public class Solution {

    /**
    
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0, min = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
            if (prices[i] <= min)
                min = prices[i];
            else {
                max = Math.max(max, prices[i] - min);
            }
        }
        
        return max;
    }
}

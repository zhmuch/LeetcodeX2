public class Solution {

    /**
     * LC121. Best Time to Buy and Sell Stock
     * At most one transaction
     * 
     */
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
    
    /**
     * LC122. Best Time to Buy and Sell Stock II
     * Any transaction
     * 
     */
    public int maxProfit(int[] prices) {
        int max = 0, buyIn = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] > buyIn)
                max += prices[i] - buyIn;
            buyIn = prices[i];
        }    
    
        return max;
    }
    
    
}

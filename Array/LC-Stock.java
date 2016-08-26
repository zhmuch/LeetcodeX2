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
    
    /**
     * LC123. Best Time to Buy and Sell Stock III
     * 
     * O(n^2) Time Limit Exceed
     * 
     */
     public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
            
        int[] oneTran = new int[len];
        int max = 0;
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            oneTran[i] = Math.max(0, prices[i] - min);
            
            int currMin = Integer.MAX_VALUE, currMax = 0;
            for(int j = i + 1; j < len; j++) {
                currMin = Math.min(currMin, prices[j]);
                currMax = Math.max(currMax, prices[j] - currMin);
            }
            
            max = Math.max(max, oneTran[i] + currMax);
        }
        
        return max;
    }
    
    /**
     * LC123. Best Time to Buy and Sell Stock III
     * 
     * 两遍扫描，左到右最大获利，右daozuo最大亏损；
     * 
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
            
        int[] maxPro = new int[len];
        int min = prices[0];
        for(int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            maxPro[i] = Math.max(maxPro[i - 1], prices[i] - min);
        }
        
        int[] maxCon = new int[len];
        int max = prices[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxCon[i] = Math.max(maxCon[i + 1], max - prices[i]);
        }
        
        int maxProfit = 0;
        for(int i = 0; i < len; i++)
            maxProfit = Math.max(maxProfit, maxPro[i] + maxCon[i]);
            
        return maxProfit;
    }
    
    /**
     * LC188. Best Time to Buy and Sell Stock IV
     * 
     * Time Limit Exceed;
     * 
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
            
        int[] currProfit = new int[len];
        int[] prevProfit = new int[len];
        
        int maxP = 0;
        for( ; k > 0; k--) {
            int tmpMax = - prices[0];
            for(int i = 1; i < len; i++) {
                currProfit[i] = Math.max(currProfit[i - 1], prices[i] + tmpMax);
                tmpMax = Math.max(tmpMax, prevProfit[i] - prices[i]);
                maxP = Math.max(currProfit[i], maxP);
            }
            
            int[] tmp = prevProfit;
            prevProfit = currProfit;
            currProfit = tmp;
            
            // ! ! ! ! 可能正确 ! ! ! !
            // if (prevProfit[len - 1] == currProfit[len - 1])
            //     return prevProfit[len - 1];
        }
        
        return maxP;
    }
    
    /**
     * LC309. Best Time to Buy and Sell Stock with Cooldown
     *
     */
    public int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE, release = 0, cool = 0;
        int tmpHold, tmpRelease, tmpCool;
        
        for(int i = 0; i < prices.length; i++) {
            tmpHold = hold;
            tmpRelease = release;
            tmpCool = cool;
            
            hold = Math.max(tmpHold, cool - prices[i]);
            release = Math.max(tmpRelease, tmpHold + prices[i]);
            cool = Math.max(cool, tmpRelease);
        }
        
        return Math.max(release, cool);
    }
    
}

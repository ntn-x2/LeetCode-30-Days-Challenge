class Solution {
    
    public int maxProfit(int[] prices) {
        
        if (prices.length <= 1) {
            return 0;
        }
        
        int totalGain = 0;
        int buyPrice = -1;          //buyPrice = -1 -> we are in "buying mode"
        
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice == -1) {
                if (prices[i] >= prices[i-1]) {     //If price is increasing, buy at previous price
                    buyPrice = prices[i-1];
                }
            } else {
                if (prices[i] < prices[i-1]) {      // If price is decreasing, sell at previous price
                    totalGain += prices[i-1] - buyPrice;
                    buyPrice = -1;
                }
            }
        }
        
        if (buyPrice != -1) {
            totalGain += prices[prices.length-1] - buyPrice;
        }
        
        return totalGain;
    }
}
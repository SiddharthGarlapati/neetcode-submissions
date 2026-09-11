class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int prevMin = prices[0];

        for(int i = 1 ; i < n ; i++){
            if(prices[i] < prevMin){
                prevMin = prices[i];
            }
            else{
                int profit = prices[i] - prevMin;
                maxProfit = Math.max(maxProfit,profit);
            }

        }

        return maxProfit;
        
    }
}

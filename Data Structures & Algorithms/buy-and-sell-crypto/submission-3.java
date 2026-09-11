class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int left = 0;
        int maxProfit = 0;

        for(int right = 1; right < n ; right++){
            if(prices[right] - prices[left] <= 0){
                left = right;
            }
            else{
                maxProfit = Math.max(maxProfit,prices[right] - prices[left]);
            }
        }

        return maxProfit;
    }
}

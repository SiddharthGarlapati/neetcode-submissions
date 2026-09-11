class Solution {
    public int maxProfit(int[] prices) {

        int max_profit = 0;
        int left = 0;
        int right = 1;
        int n = prices.length;

        while(right < n){
            if(prices[left] < prices[right]){
                int curr_profit = prices[right] - prices[left];
                max_profit = Math.max(max_profit, curr_profit);
            }
            else{
                left = right;
            }
            right++;


        }

        return max_profit;
        
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int prevMin = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            prevMin = Math.min(prevMin, price);
            maxProfit = Math.max(maxProfit, price - prevMin);
        }

        return maxProfit;
    }
}
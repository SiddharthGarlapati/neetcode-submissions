class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int holding = 0 ; holding <= 1; holding++){
                if(holding == 0){
                    dp[i][0] = Math.max(dp[i+1][0],-prices[i] + dp[i+1][1]);
                }
                else{
                    dp[i][1] = Math.max(dp[i+1][1], prices[i] + dp[i+1][0]);
                }

            }
        }

        return dp[0][0];
        
    }
}
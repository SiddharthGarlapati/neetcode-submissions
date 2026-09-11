class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        int INF = 100000;

        for(int i = 1 ; i <= amount ; i++){
            dp[n][i] = INF;
        }

        for(int i = n - 1; i >= 0 ; i--){
            for(int amt = 0 ; amt <= amount ; amt++ ){
                int skip = dp[i+1][amt];

                int take = INF;
                if(amt - coins[i] >= 0){
                    take = 1 + dp[i][amt - coins[i]];
                } 

                dp[i][amt] = Math.min(skip,take);
            }
        }

        return (dp[0][amount] >= INF) ? -1 : dp[0][amount];
    }
}

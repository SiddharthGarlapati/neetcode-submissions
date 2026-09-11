class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = 1;
        }

        for(int i = n - 1; i >= 0 ; i--){
            for(int amt = 1 ; amt <= amount ; amt++){
                int skip = dp[i+1][amt];

                int take = 0;
                if(amt - coins[i] >= 0){
                    take = dp[i][amt - coins[i]];
                }

                dp[i][amt] = skip + take;
            }
        }

        return dp[0][amount];
        
    }
}

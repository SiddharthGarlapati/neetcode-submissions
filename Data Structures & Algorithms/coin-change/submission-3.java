class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        int INF = 100000;
        Arrays.fill(dp,INF);

        dp[0] = 0;

        for(int coin : coins){
            for(int amt = coin; amt <= amount ; amt++){
                dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
            }
        }

        int res = dp[amount];

        return (res >= INF) ? -1 : res;
        
    }
}

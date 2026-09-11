class Solution {
    Integer[][] memo;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        memo = new Integer[n][amount + 1];

        int res = dfs(0,amount,coins);

        return (res >= 100000) ? -1 : res;
        
    }

    private int dfs(int i, int amount, int[] coins){
        if(amount == 0){
            return 0;
        }

        if(i == coins.length || amount < 0 ){
            return 100000;
        }

        if(memo[i][amount] != null){
            return memo[i][amount];
        }

        int take = 1 + dfs(i,amount - coins[i], coins);
        int skip = dfs(i+1, amount, coins);

        memo[i][amount] = Math.min(take,skip);
        return memo[i][amount];
    }
}

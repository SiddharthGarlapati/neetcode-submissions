class Solution {
    Integer memo[][];
    public int change(int amount, int[] coins) {
        int n = coins.length;
        memo = new Integer[n][amount + 1];

        return dfs(0,amount,coins);
    }

    private int dfs(int i, int amount , int[] coins){
        if(amount == 0){
            return 1;
        }

        if(i == coins.length || amount < 0 ){
            return 0;
        }

        if(memo[i][amount] != null){
            return memo[i][amount];
        }
        

        int skip = dfs(i+1, amount , coins);
        int take = dfs(i, amount - coins[i], coins);

        memo[i][amount] = skip + take;

        return memo[i][amount];

    }
}

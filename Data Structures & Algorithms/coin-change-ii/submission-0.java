class Solution {
    int[][] memo;
    public int change(int amount, int[] coins) {

        memo = new int[coins.length][amount + 1];

        for(int[] row: memo){
            Arrays.fill(row, -1);
        }

        return dfs(0,amount,coins);
        
    }

    private int dfs(int index, int amount , int[] coins){

        if(amount == 0) return 1;

        if(amount < 0 || index == coins.length) return 0;

        if(memo[index][amount] != -1) return memo[index][amount];
        
        int take = dfs(index, amount - coins[index],coins);

        int skip = dfs(index + 1, amount , coins);

        memo[index][amount] = take + skip;

        return memo[index][amount];
    }
}

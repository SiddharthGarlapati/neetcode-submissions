class Solution {
    Integer[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new Integer[n][2];
        return dfs(0,0,prices);
    }

    private int dfs(int i , int holding, int[] prices){
        if(i >= prices.length){
            return 0;
        }

        if(memo[i][holding] != null){
            return memo[i][holding];
        }

        int skip = dfs(i+1,holding, prices);

        int take;

        if(holding == 0){
            take = -prices[i] + dfs(i+1,1,prices);
        }
        else{
            take = prices[i] + dfs(i+2, 0,prices);
        }

        memo[i][holding] =  Math.max(take,skip);
        return memo[i][holding];
    }
}

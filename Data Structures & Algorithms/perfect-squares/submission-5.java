class Solution {
    Integer[][] memo;
    public int numSquares(int n) {

        memo = new Integer[n+1][n+1];

        return dfs(1,n);
    }

    private int dfs(int i, int n){

        if(n == 0){
            return 0;
        }

        if(i * i > n){
            return 100000;
        }
        if(memo[i][n] != null){
            return memo[i][n];
        }

        int skip = dfs(i+1,n);
        int take = 1 + dfs(i,n - (i*i));

        memo[i][n] = Math.min(skip,take);
        return memo[i][n];

    }
}

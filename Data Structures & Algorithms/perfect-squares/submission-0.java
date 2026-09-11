class Solution {
    Integer memo[][];
    public int numSquares(int n) {
        memo = new Integer[n+1][n+1];

        return dfs(1,n);
    }

    private int dfs(int i , int n){
        if(n == 0){
            return 0;
        }
        if( i * i > n || n < 0 ){
            return 100000;
        }

        if(memo[i][n] != null){
            return memo[i][n];
        }

        int take = 1 + dfs(i , n - (i * i));
        int skip = dfs(i+1,n);

        memo[i][n] = Math.min(take,skip);
        return memo[i][n];

    }


}
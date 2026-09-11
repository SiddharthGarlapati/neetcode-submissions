class Solution {
    public int numSquares(int n) {
        int maxSquare = (int) Math.sqrt(n);
        int[] dp = new int[n+1];
        int INF = 100000;
        Arrays.fill(dp,INF);
        dp[0] = 0;

        for(int i = 1 ; i * i <= n;i++ ){
            int square = i*i;
            for(int sum = square ; sum <= n ; sum++){
                dp[sum] = Math.min(dp[sum], 1 + dp[sum - square]);
            }
        }

        return dp[n]; 
    }
}
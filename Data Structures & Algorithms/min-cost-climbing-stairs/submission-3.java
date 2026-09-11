class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp2 = 0;
        int dp1 = 0;

        for(int i = 2; i <= n ; i++){
            int dp = Math.min(dp2 + cost[i - 2] , dp1 + cost[i - 1]);
            dp2 = dp1;
            dp1 = dp;
        }

        return dp1;


    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        
        int dp2 = cost[0];
        int dp1 = cost[1];

        for(int i = 2; i < n ; i++){
            int curr = cost[i] + Math.min(dp2,dp1);
            dp2 = dp1;
            dp1 = curr;
        }

        return Math.min(dp1,dp2);
        
    }
}

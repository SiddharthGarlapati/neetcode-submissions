class Solution {
    public int climbStairs(int n) {
        int dp2  = 1;
        int dp1 = 2;

        if(n <= 2){
            return n;
        }

        for(int i = 3 ; i <= n ; i++){
            int dp = dp1 + dp2;
            dp2 = dp1;
            dp1 = dp;
        }

        return dp1;

        
    }
}

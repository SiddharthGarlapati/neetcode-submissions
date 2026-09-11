class Solution {
    public int climbStairs(int n) {

        if(n <= 1){
            return n;
        }
        int dp2 = 1;
        int dp1 = 2;

        for(int i = 3; i <= n ; i++){
            int dp = dp2 + dp1;
            dp2 = dp1;
            dp1 = dp;
        } 

        return dp1;
        
    }
}

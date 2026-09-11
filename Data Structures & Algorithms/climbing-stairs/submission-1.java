class Solution {
    public int climbStairs(int n) {
        
        if(n <= 2) return n;

        int dp2 = 1; 
        int dp1 = 2;

        for(int i = 3; i <= n ; i++){
            int curr = dp2 + dp1;
            dp2 = dp1;
            dp1 = curr;
        }

        return dp1;

        
    }
}

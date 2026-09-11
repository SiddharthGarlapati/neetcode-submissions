class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j <= nums[i] ; j++){
                if(i + j < n){
                    dp[i + j] = dp[i];
                }
 
            }
        }

        return dp[n - 1];

    }
}

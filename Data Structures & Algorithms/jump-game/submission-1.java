class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for(int i = n - 2 ; i >= 0 ; i--){

            int maxJumps = nums[i];

            for(int step = 1; step <= maxJumps ; step++){
                if(dp[i+ step]){
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[0];
        
    }
}

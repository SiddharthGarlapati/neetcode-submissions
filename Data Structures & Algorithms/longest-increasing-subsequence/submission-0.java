class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        int[] dp = new int[n+1];
        dp[n-1] = 1;
        int max_length = 1;

        for(int i = n-2 ; i >= 0 ; i--){
            dp[i] = 1;
            for(int j = i+1; j < n; j++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i],1 + dp[j]);
                    if(dp[i] > max_length){
                        max_length = dp[i];
                    }
                }

            }
        }

        return max_length;




        
    }
}

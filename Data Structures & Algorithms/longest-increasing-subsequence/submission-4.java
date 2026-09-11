class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int LIS = 1;

        for(int i = n - 2 ; i >= 0 ; i--){
            for(int j = i + 1 ; j < n ; j++){
                if(nums[j] > nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            LIS = Math.max(LIS,dp[i]);
        }

        return LIS;
        
    }
}

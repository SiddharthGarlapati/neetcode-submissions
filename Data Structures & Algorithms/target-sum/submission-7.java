class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        if (target > totalSum || target < -totalSum) {
            return 0;
        }

        int offset = totalSum;

        int[][] dp = new int[n+1][2 * totalSum + 1];
        dp[0][0 + offset] = 1;

        for(int i = 0 ; i < n ; i++){
            for(int sum = -totalSum ; sum <= totalSum ; sum++){
                if(dp[i][sum + offset] == 0){
                    continue;
                }

                int count = dp[i][sum + offset];

                int addSum = sum + nums[i];
                int subSum = sum - nums[i];

                dp[i+1][addSum + offset] += count;
                dp[i+1][subSum + offset] += count;
            }
        }

        return dp[n][target + offset];
        
    }
}

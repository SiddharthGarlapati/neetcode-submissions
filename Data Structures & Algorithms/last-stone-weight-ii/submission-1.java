class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int totalSum = 0;
        for(int stone : stones){
            totalSum += stone;
        }
        int target = totalSum / 2;
        boolean[][] dp = new boolean[n+1][target + 1];

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = true;
        }

        for(int i = n - 1; i >= 0 ; i--){
            for(int sum = 1 ; sum <= target ; sum++){
                boolean skip = dp[i+1][sum];

                boolean take = false;
                
                if(sum - stones[i] >= 0){
                    take = dp[i+1][sum - stones[i]];
                }

                dp[i][sum] = skip || take;
            }
        }

        for(int sum = target ; sum >= 0 ; sum--){
            if(dp[0][sum]){
                int group1 = sum;
                int group2 = totalSum - sum;
                return Math.abs(group1 - group2);
            }
        }

        return 0;
    }
}
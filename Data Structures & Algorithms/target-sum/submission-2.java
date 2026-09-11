class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer,Integer>[] dp = new HashMap[nums.length + 1];

        for(int i = 0 ; i <= nums.length ; i++){
            dp[i] = new HashMap<>();
        }

        dp[0].put(0,1);

        for(int i = 0 ; i < nums.length; i++){
             for(int currSum : dp[i].keySet()){

                int ways = dp[i].get(currSum);
                
                int add = currSum + nums[i];
                int subtract = currSum - nums[i];

                dp[i+1].put(add,dp[i+1].getOrDefault(add,0) + ways);
                dp[i+1].put(subtract,dp[i+1].getOrDefault(subtract,0) + ways);
             }
        }

        return dp[nums.length].getOrDefault(target,0);
        
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        Map<Integer,Integer> dp = new HashMap<>();

        dp.put(0,1);

        for(int i = 0 ; i < nums.length ; i++){
            Map<Integer,Integer> nextDp = new HashMap<>();
            for(int currSum : dp.keySet()){
                int ways = dp.get(currSum);

                int add = currSum + nums[i];
                int subtract = currSum - nums[i];

                nextDp.put(add,nextDp.getOrDefault(add,0) + ways);
                nextDp.put(subtract, nextDp.getOrDefault(subtract,0) + ways);
            }

            dp = nextDp;
        }
        
        return dp.getOrDefault(target,0);
    }
}

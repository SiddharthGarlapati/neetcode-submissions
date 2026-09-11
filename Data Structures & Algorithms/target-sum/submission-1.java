class Solution {
    Map<String,Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();

        return dfs(0,0,target, nums);
        
    }

    private int dfs(int index, int currSum, int target, int[] nums){
        if(index == nums.length) return (currSum == target)? 1: 0;

        String key  = index + "," + currSum;

        if(memo.get(key) != null) return memo.get(key);
        
        int add = dfs(index + 1, currSum + nums[index],target, nums);
        int subtract = dfs(index + 1, currSum - nums[index],target, nums);

        memo.put(key, add + subtract);

        return memo.get(key);
    }
}
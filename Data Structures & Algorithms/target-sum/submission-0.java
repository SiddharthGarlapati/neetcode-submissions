class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {

        return dfs(0,0,target, nums);
        
    }

    private int dfs(int index, int currSum, int target, int[] nums){
        if(currSum == target && index == nums.length) return 1;

        if(index == nums.length) return 0;
        
        int positive = dfs(index + 1, currSum + nums[index],target, nums);
        int negative = dfs(index + 1, currSum - nums[index],target, nums);

        return positive + negative;
    }
}

class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for(int num: nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        memo = new Boolean[n][target + 1];

        return dfs(0,target,nums);
    }

    private boolean dfs(int i , int target, int[] nums){
        if(target == 0){
            return true;
        }

        if(i == nums.length || target < 0){
            return false;
        }

        if(memo[i][target] != null){
            return memo[i][target];
        }

        boolean take = dfs(i + 1, target - nums[i] , nums);
        boolean skip = dfs(i + 1, target, nums);

        memo[i][target] = take || skip;

        return memo[i][target];
    }
}

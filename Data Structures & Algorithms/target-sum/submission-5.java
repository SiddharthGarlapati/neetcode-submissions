class Solution {
    Integer[][]memo;
    int offset;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;

        for(int num: nums){
            totalSum += num;
        }

        offset = totalSum;

        memo = new Integer[n][2 * totalSum + 1];
        return dfs(0,0,nums,target);
        
    }

    private int dfs(int i, int sum , int[] nums, int target){
        if(i == nums.length){
            return (sum == target) ? 1 : 0;
        }

        int index = offset + sum;
        if(memo[i][index] != null){
            return memo[i][index];
        }

        int add = dfs(i + 1, sum + nums[i], nums, target);
        int sub = dfs(i + 1 , sum - nums[i], nums,target);

        memo[i][index] = add + sub;

        return memo[i][index];

    }
}

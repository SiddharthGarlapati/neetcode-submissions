class Solution {
    Integer[][] memo;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];

        return dfs(0,nums,-1);
    }

    private int dfs(int i , int[] nums, int prevIndex){

        if(i == nums.length){
            return 0;
        }

        if(memo[i][prevIndex + 1] != null){
            return memo[i][prevIndex + 1];
        }

        int take = 0;
        if(prevIndex == -1 || nums[i] > nums[prevIndex]){
            take = 1 + dfs(i + 1, nums , i);
        }
        int skip = dfs(i + 1, nums, prevIndex);

        memo[i][prevIndex + 1] = Math.max(take,skip);
        return memo[i][prevIndex + 1];
    }
}

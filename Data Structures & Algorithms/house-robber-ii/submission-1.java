class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length - 1)),
        helper(Arrays.copyOfRange(nums,1,nums.length)));
        
    }

    public int helper(int[] nums){

        if(nums.length == 1) return nums[0];

        int dp2 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            int curr = Math.max(nums[i] + dp2 , dp1);
            dp2 = dp1;
            dp1 = curr;
        }

        return dp1;

    }
}

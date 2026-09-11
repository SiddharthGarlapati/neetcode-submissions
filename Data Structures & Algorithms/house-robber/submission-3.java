class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int rob2 = nums[0];
        int rob1 = Math.max(nums[0],nums[1]);

        for(int i = 2; i < n ; i++){
            int rob = Math.max(rob2 + nums[i], rob1);
            rob2 = rob1;
            rob1 = rob;
        }

        return rob1;
    }
}

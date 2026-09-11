class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        int robFirst = houseRob(nums,0,n - 2);
        int robLast = houseRob(nums, 1, n - 1);

        return Math.max(robFirst,robLast);
    }

    private int houseRob(int[] nums, int start, int end){
        int rob2 = 0;
        int rob1 = 0;

        for(int i = start ; i <= end ; i++){
            int rob = Math.max(rob2 + nums[i], rob1);
            rob2 = rob1;
            rob1 = rob;
        }

        return rob1;
    }
}

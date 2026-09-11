class Solution {
    public int maxProduct(int[] nums) {

        int res = Integer.MIN_VALUE;
        int n = nums.length;

        int cur_max = 1;
        int cur_min = 1;

        for(int i = 0; i < n ; i++){

            int temp_cur_max = cur_max;
            cur_max = Math.max(nums[i],Math.max( nums[i] * cur_max, nums[i] * cur_min));
            cur_min = Math.min(nums[i],Math.min( nums[i] * temp_cur_max , nums[i] * cur_min));
            res = Math.max(res, cur_max);

        }



        return res;


        
    }
}

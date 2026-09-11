class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = nums[0];
        int currMaxSum = nums[0];
        int currMinSum = nums[0];

        
        for(int i = 1; i < n ; i++){
            if(currMaxSum <= 0){
                currMaxSum = 0;
            }

            currMaxSum += nums[i];
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum + nums[i], nums[i]);
            minSum = Math.min(currMinSum, minSum);

            total += nums[i];
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, total - minSum);
        
    }
}
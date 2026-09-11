class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = Math.max(0,nums[0]);

        for(int i = 1 ; i < nums.length ; i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0){
                currSum = 0;
            }

        }

        return maxSum;

    }
}

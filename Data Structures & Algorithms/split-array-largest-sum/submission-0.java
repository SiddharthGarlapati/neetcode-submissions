class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int l = nums[0];
        int r = 0;

        for(int i = 0 ; i < n; i++){
            l = Math.max(l, nums[i]);
            r += nums[i];
        }

        int ans = r;

        while( l <= r){
            int mid = l + ( r - l)/2;

            if(canSplit(mid, nums, k)){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }

        }
        

        return ans;
    }

    private boolean canSplit(int maxAllowedSum, int[] nums, int k){
        int subArrays = 1;
        int currSum = maxAllowedSum;

        for(int num : nums){
            if(num > currSum){
                subArrays++;
                currSum = maxAllowedSum;
            }
            currSum -= num;
        }

        return subArrays <= k;
    }
}
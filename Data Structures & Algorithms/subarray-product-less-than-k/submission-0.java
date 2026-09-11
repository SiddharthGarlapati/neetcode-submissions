class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;

        int res = 0;
        int left = 0;
        int currProd = 1;

        for(int right = 0; right < n ; right++){
            
            currProd *= nums[right];

            while(currProd >= k && left <= right ){
                currProd /= nums[left];
                left++;
            }

            res += right - left + 1;

        }

        return res;
        
    }
}
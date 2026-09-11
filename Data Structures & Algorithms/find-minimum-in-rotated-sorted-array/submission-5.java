class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int res = Integer.MAX_VALUE;
        while(left <= right){
            if(nums[left] < nums[right]){
                res = Math.min(res,nums[left]);
                break;
            }

            int mid = left + (right - left)/2;
            res = Math.min(res,nums[mid]);

            if(nums[left] <= nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return res;
    }
}

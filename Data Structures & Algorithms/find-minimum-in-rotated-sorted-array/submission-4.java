class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0 ;
        int r = n - 1;
        int min = nums[0];

        while(l <= r){
            if(nums[l] <= nums[r]){
                min = Math.min(min,nums[l]);
                break;
            }

            int mid = l + (r - l )/2;

            if(nums[mid] >= nums[l]){
                l = mid + 1;
            }
            else{
                r = mid ;
            }


        }

        return min;
        
    }
}

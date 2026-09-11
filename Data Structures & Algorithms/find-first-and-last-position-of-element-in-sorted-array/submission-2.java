class Solution {
    public int[] searchRange(int[] nums, int target) {

        int starting  = binarySearch(nums, target, true);
        int ending =  binarySearch(nums, target, false);

        return new int[]{starting, ending};
        
    }

    private int binarySearch(int[] nums, int target, boolean leftBias){
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int index = -1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(nums[mid] < target){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid - 1;
            }
            else{
                index = mid;
                if(leftBias){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }  
            }

        }


        return index;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;

        int left = 0;
        int right = n - 1;
        int pivotIndex = n - 1;

        while(left <= right){
            pivotIndex = getPivotIndex(left, right,nums);
            if(target == pivotIndex){
                return nums[pivotIndex];
            }
            if(target < pivotIndex){
                right = pivotIndex - 1;
            }
            else{
                left = pivotIndex + 1;
            }
        }

        return -1;
    }

    private int getPivotIndex(int left, int right,int[] nums){
        int index = left;

        for(int i = left ; i < right ; i++){
            if(nums[i] <= nums[right]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        int temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;

        return index;
    }
}

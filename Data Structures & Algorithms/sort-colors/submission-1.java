class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int i = 0;

        while(i <= right){
            if(nums[i] == 2){
                swap(i,right,nums);
                right--;
            }
            else if(nums[i] == 0){
                swap(i,left,nums);
                left++;
                i++;
            }
            else{
                i++;
            }
        }
        
    }

    private void swap(int i , int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
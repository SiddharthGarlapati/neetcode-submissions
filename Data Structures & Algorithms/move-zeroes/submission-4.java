class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0 ; 
        int right = 1;

        while( right < n){
            if(nums[left] == 0){
                while( right < n - 1 && nums[right] == 0){
                    right++;
                }
                nums[left] = nums[right];
                nums[right] = 0;
            }
            left++;
            right++;
        }
        
    }
}
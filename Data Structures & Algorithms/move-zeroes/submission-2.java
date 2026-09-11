class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;

        while(left < n && nums[left] != 0) left++;

        for(int right = left + 1 ; right < n ; right++){
            if(nums[right] == 0 ){
                continue;
            }
            else{
                nums[left] = nums[right];
                nums[right] = 0;
                left++;

            }
        }


        
    }
}
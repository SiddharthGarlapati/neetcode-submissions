class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 1;
        int count = 1;

        for(int right = 1; right < n ; right++){
            if(nums[right] == nums[right - 1]){
                count++;
            }
            else{
                count = 1;
            }

            if(count <= 2){
                nums[left] = nums[right];
                left++;
            }

        }

        return left;
        
    }
}
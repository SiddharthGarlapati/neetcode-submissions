class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left =0;

        for(int right = 0; right < n ; right++ ){
            if(nums[right] == val) continue;
            else{
                nums[left] = nums[right];
                left++;
            }
        }
        
        return left;
    }
}
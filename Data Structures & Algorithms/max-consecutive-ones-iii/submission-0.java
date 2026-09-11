class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        
        int sum = 0;
        int maxOnes = 0;
        int left =0;

        for(int right = 0; right < n; right++){
            sum += nums[right];
            while((right - left + 1) - sum > k){
                sum -= nums[left];
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
        
    }
}
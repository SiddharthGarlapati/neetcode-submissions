class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> prefixSums = new HashMap<>();
        prefixSums.put(0,1);

        int currSum = 0;
        int res = 0;

        for(int i = 0 ; i < n ; i++){
            currSum += nums[i];
            int diff = currSum - k;
            res += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0 ) + 1);
        }


        return res;
        
    }
}
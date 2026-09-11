class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        for(int num: nums){
            set.add(num);
        }

        for(int i = 0 ; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int len = 0;
                while(set.contains(nums[i] + len)){
                    len++;
                }

                maxLen = Math.max(len , maxLen);
            }
        }

        return maxLen;
        
    }
}

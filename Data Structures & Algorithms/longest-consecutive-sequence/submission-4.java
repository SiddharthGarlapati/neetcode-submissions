class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            if(!set.contains(num - 1)){
                int len = 0;
                while(set.contains(num + len)){
                    len++;
                    maxLen = Math.max(len,maxLen);
                }
            }
        }

        return maxLen;
        
    }
}

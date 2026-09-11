class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : set){
            if(set.contains(num - 1 )){
                continue;
            }
            else{
                int length = 0;
                while ( set.contains(num + length)){
                    length ++;
                }
                longest = Math.max(length,longest);
            }
        }

        return longest;
        
    }
}

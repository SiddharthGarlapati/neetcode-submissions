class Solution {
    public int lengthOfLongestSubstring(String s) {


        int n = s.length();
        int maxLen = 0;
        int left = 0;

        Map<Character,Integer> map = new HashMap<>();


        for(int right = 0 ; right < n ; right++){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar,0) + 1);

            while(map.get(rightChar) > 1 ){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen,right - left + 1);
        }

        return maxLen;
        
    }
}

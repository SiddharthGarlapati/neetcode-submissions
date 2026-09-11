class Solution {
    public int characterReplacement(String s, int k) {

        int n = s.length();

        int maxLen = 0;

        int left = 0 ;

        int maxf = 0;

        int[] count = new int[26];

        for(int right = 0; right < n ; right++){
            int rightIndex = s.charAt(right) - 'A';
            count[rightIndex]++;

            maxf = Math.max(maxf,count[rightIndex]);

            while((right - left + 1) - maxf > k){
                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }


        return maxLen;

        
    }
}

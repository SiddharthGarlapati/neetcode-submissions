class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int left = 0;
        int[] count = new int[26];
        int res = 0;
        

        for(int right = 0; right < n ; right++){
            char r = s.charAt(right);
            count[r - 'A']++;

            int maxf = maxFreq(count);

            while( (right - left + 1) - maxf > k){
                char l = s.charAt(left);
                count[l - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
        
    }

    private int maxFreq(int[] count){
        int max = 0;

        for(int num: count){
            max = Math.max(num,max);
        }

        return max;
    }
}

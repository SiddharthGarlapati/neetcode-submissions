class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for(int i = 0 ; i < m ; i ++){
            s1Count[ s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++){
            if(s1Count[i] == window[i]){
                matches++;
            }
        }


        int left = 0 ; 

        for(int right = m ; right < n; right++){
            if(matches == 26) return true;
            char ch1 = s2.charAt(right);
            int lastIndex = ch1 - 'a';
            window[lastIndex]++;
            if(s1Count[lastIndex] == window[lastIndex]){
                matches++;
            }
            else if(s1Count[lastIndex] + 1 == window[lastIndex]){
                matches--;
            }

            char ch2 = s2.charAt(left);
            int firstIndex = ch2 - 'a';
            window[firstIndex]--;
            if(s1Count[firstIndex] == window[firstIndex]){
                matches++;
            }
            else if (s1Count[firstIndex] - 1 == window[firstIndex]){
                matches--;
            }

            left++;

        }

        return matches == 26;
        
    }
}

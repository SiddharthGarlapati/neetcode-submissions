class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0 ; i < m ; i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;

        }

        int matches = 0;

        for(int i = 0; i < 26 ; i++){
            if(s1Count[i] == s2Count[i]){
                matches++;
            }
        }

        int left = 0;


        for(int right = m ; right < n ; right++){
            if(matches == 26){
                return true;
            }

            int rightIndex = s2.charAt(right) - 'a';
            s2Count[rightIndex]++;
            if(s1Count[rightIndex] == s2Count[rightIndex]){
                matches++;
            }
            if(s1Count[rightIndex] + 1 == s2Count[rightIndex]){
                matches--;
            }

            int leftIndex = s2.charAt(left) - 'a';
            s2Count[leftIndex]--;
            if(s1Count[leftIndex] == s2Count[leftIndex]){
                matches++;
            }
            if(s1Count[leftIndex] - 1 == s2Count[leftIndex]){
                matches--;
            }

            left++;
        }

        return matches == 26;
        
    }
}

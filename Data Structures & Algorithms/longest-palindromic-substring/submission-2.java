class Solution {
    int maxLen = 0;
    int resL = -1;
    int resR = -1;
    public String longestPalindrome(String s) {
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }

        return s.substring(resL, resR + 1);

    }

    private void expand(String s, int l, int r){


        while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){

            int len = r - l + 1;
            if( len > maxLen){
                maxLen = len;
                resL = l;
                resR = r;
            }

            l--;
            r++;
             
        }

    }
}

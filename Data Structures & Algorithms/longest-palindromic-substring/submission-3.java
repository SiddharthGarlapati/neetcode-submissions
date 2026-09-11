class Solution {
    int resL;
    int resR;
    int resLength;
    public String longestPalindrome(String s) {
        int n = s.length();
        resL = -1;
        resR = -1;
        resLength = 0;

        for(int i = 0 ; i < n ; i++){
            palindromeCheck(i,i,s);
        }

        for(int i = 0 ; i < n - 1 ; i++){
            palindromeCheck(i,i+1,s);
        }

        return s.substring(resL,resR + 1);
        
    }

    private void palindromeCheck(int left, int right , String s){

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right - left + 1 > resLength){
                resLength = right - left + 1;
                resL = left;
                resR = right;
            }
            left--;
            right++;
        }
    }
}

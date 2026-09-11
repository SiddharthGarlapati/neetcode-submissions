class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String maxOdd = "";
        String maxEven = "";

        for(int i = 0 ; i < n ; i++){
            String s1 = expand(s,i,i);
            String s2 = expand(s,i,i+1);

            if(s1.length() > maxOdd.length()){
                maxOdd = s1;
            }
            if(s2.length() > maxEven.length()){
                maxEven = s2;
            }
        }

        return maxOdd.length() > maxEven.length() ? maxOdd : maxEven;

    }

    private String expand(String s, int l, int r){
        String temp = "";

        while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if( r - l + 1 > temp.length()){
                temp = s.substring(l,r+1);
            }

            l--;
            r++;
             
        }

        return temp;
    }
}

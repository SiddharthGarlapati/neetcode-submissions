class Solution {
    public int numDecodings(String s) {

        int n = s.length();
        if(s.charAt(0) == '0') return 0;

        int dp2 = 1;
        int dp1 = 1;
        
        for( int i = 1; i < n ; i++){
            int cur = 0;

            if( s.charAt(i) != '0' ){
                cur += dp1;
            }
            int valid = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if ( valid >= 10 && valid <=26 ){
                cur += dp2;
            }
            dp2 = dp1;
            dp1 = cur;

            if(dp1 == 0) return 0;
            
        }

        return dp1;


        
    }
}

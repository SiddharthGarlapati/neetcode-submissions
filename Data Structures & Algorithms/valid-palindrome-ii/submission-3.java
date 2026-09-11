class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while( l < r){
            if(s.charAt(l) != s.charAt(r)){
                return check(l , r-1 , s) || check(l + 1, r, s);
            }

            l++;
            r--;
        }

        return true;
        
    }

    private boolean check(int l , int r, String s){
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;

        }

        return true;
    }
}
class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0 ; 
        int r = n - 1;
        int k = 0;

        return isValid(l,r,k,s);

    }

    private boolean isValid(int l , int r, int k,String s){
        if(k > 1){
            return false;
        }

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                k++;
                return isValid(l, r -1 , k, s) || isValid(l + 1, r,k,s);
            }
            l++;
            r--;
        }

        return true;
    }
}
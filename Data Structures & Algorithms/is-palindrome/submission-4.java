class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0 ;
        int r = n - 1;
        s = s.toLowerCase();

        while(l < r){
            while(l < r && !Character.isLetterOrDigit(s.charAt(l)) ){
                l++;
            }
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(s.charAt(l) != s.charAt(r)){
                return false;
            }

            l++;
            r--;

        }

        return true;
        
    }
}

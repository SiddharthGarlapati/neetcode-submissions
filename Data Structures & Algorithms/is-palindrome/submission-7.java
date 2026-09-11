class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while(l < r){
            while(l < r && !alphanumeric(s.charAt(l))){
                l++;
            }
            while(l < r && !alphanumeric(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean alphanumeric(char ch){
        return ((ch >= '0' &&  ch <= '9')||
                 (ch >= 'a' && ch <= 'z')||
                 (ch >= 'A' && ch <= 'Z'));
    }
}

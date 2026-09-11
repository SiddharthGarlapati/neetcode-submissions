class Solution {
    int count;
    public int countSubstrings(String s) {
        int n = s.length();
        count = 0;

        for(int i = 0 ; i < n; i++){
            palindrome(s,i,i);
            palindrome(s,i,i+1);
        }

        return count;
        
    }

    private void palindrome(String s, int left, int right){
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}

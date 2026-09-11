class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int l = 0;
        int r = n - 1;

        while(l < r){
            swap(l,r,s);
            l++;
            r--;
        }
        
    }

    private void swap(int l , int r, char[] s){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
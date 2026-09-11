class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        dp = new Boolean[m + 1][n + 1];

        if( m + n != s3.length()) return false;


        return dfs(0,0,s1,s2,s3,m,n);

        
    }

    private boolean dfs(int i, int j , String s1,String s2, String s3, int m , int n){
        if(i == m && j == n) return true;

        if(dp[i][j] != null) return dp[i][j];

        if(i < m && s1.charAt(i) == s3.charAt(i+j) &&
         dfs(i+1,j,s1,s2,s3,m,n)) return true;

        if(j < n && s2.charAt(j) == s3.charAt(i+j) &&
        dfs(i,j+1, s1,s2,s3,m,n)) return true;

        dp[i][j] = false;

        return false;


    }
}

class Solution {
    Integer[][] dp;
    int m,n;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        dp = new Integer[m+1][n+1];

        return dfs(0,0,s,t);
        
    }

    public int dfs(int i , int j, String s, String t){

        if(j == n) return 1;

        if(i == m) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = dfs(i+1,j+1,s,t) + dfs(i+1,j,s,t);
        }
        else{
            dp[i][j] = dfs(i+1,j,s,t);
        } 

        return dp[i][j];
    }
}
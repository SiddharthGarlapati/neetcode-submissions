class Solution {
    Integer dp[][];
    int m,n;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        dp = new Integer[m+1][n+1];

        return dfs(0,0,word1,word2);
        
    }

    private int dfs(int i , int j , String word1, String word2){
        if(i == m ) return n - j;
        if(j == n ) return m - i;

        if(dp[i][j] != null) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = dfs(i+1,j+1, word1,word2);
        }

        else{
            int insert = dfs(i,j+1,word1,word2);
            int delete = dfs(i+1,j,word1,word2);
            int replace = dfs(i+1,j+1,word1,word2);

            dp[i][j] = 1 + Math.min(Math.min(insert,delete),replace);
        }

        return dp[i][j];
    }
}

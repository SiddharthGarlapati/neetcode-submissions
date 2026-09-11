class Solution {
    Integer[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new Integer[m+1][n+1];

        return dfs(0,0,word1,word2);

    }

    private int dfs(int i , int j , String word1 , String word2){
        if(i == word1.length() && j == word2.length()){
            return 0;
        }
        if(i == word1.length()){
            return word2.length() - j;
        }

        if(j == word2.length()){
            return word1.length() - i;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            memo[i][j] = dfs(i+1,j+1,word1,word2);
        }
        else{
            int insert = dfs(i,j+1,word1, word2);
            int delete = dfs(i+1,j,word1,word2);
            int replace = dfs(i+1,j+1,word1,word2);

            memo[i][j] = 1 + Math.min(Math.min(insert, delete),replace);
        }

        return memo[i][j];

    }
}

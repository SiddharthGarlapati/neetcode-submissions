class Solution {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        memo = new Integer[m + 1][n + 1];
        return dfs(0,0,text1,text2);
        
    }

    private int dfs(int i , int j,String text1,String text2){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] =  1 + dfs(i+1, j+1, text1, text2);
        }
        else{
            int skipText1 = dfs(i+1, j, text1, text2);
            int skipText2 = dfs(i, j+1, text1, text2);

            memo[i][j] = Math.max(skipText1,skipText2);
        }

        return memo[i][j];
    }
}

class Solution {
    Integer[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        memo = new Integer[m][n];

        return dfs(0,0,s,t);
    }

    private int dfs(int i, int j , String s, String t){
        if(j == t.length()){
            return 1;
        }

        if(i == s.length()){
            return 0;
        }

        if(memo[i][j] != null){
            return memo[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            int take = dfs(i+1,j+1,s,t);
            int skip = dfs(i+1,j,s,t);

            memo[i][j] = take + skip;
        }
        else{
            memo[i][j] = dfs(i+1,j,s,t);
        }

        return memo[i][j];
    } 
}

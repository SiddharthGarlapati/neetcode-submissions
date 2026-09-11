class Solution {
    Integer[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        memo = new Integer[len + 1][m + 1][n + 1];

        return dfs(0,m,n,strs);
    }

    private int dfs(int i , int m , int n, String[] strs){
        if(i == strs.length){
            return 0;
        }
        if(memo[i][m][n] != null){
            return memo[i][m][n];
        }

        String str = strs[i];
        int zeroes_count = 0;
        int ones_count = 0;

        for(int ch = 0 ; ch < str.length();ch++){
            if(str.charAt(ch) == '0'){
                zeroes_count++;
            }
            if(str.charAt(ch) == '1'){
                ones_count++;
            }
        }

        memo[i][m][n] = dfs(i+1,m,n,strs);

        if(zeroes_count <= m && ones_count <= n){
            memo[i][m][n] = Math.max(memo[i][m][n],
                1 + dfs(i+1, m - zeroes_count , n - ones_count,strs));
        }

        return memo[i][m][n];
    }
}
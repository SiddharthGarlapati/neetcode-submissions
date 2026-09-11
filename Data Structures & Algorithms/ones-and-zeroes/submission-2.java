class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m+1][n+1];

        for(int i = len - 1 ; i >= 0 ; i--){
            String str = strs[i];
            int zeros = 0;
            int ones = 0;
            for(int ch = 0 ; ch < str.length(); ch++){
                if(str.charAt(ch) == '0'){
                    zeros++;
                }
                if(str.charAt(ch) == '1'){
                    ones++;
                }
            }

            for(int z = 0; z <= m ; z++){
                for(int o = 0 ; o <= n ; o++){
                    int skip = dp[i+1][z][o];
                    int take = 0;
                    if(z - zeros >= 0 && o - ones >= 0){
                        take = 1 + dp[i+1][z - zeros][o - ones];
                    }
                    dp[i][z][o] = Math.max(skip,take);
                }
            }
            
        }

        return dp[0][m][n];
        
    }
}
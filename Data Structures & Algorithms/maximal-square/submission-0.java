class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxLength = 0;

        for(int r = 0 ; r < m ; r++){
            dp[r][n - 1] = matrix[r][n - 1] - '0';
        }

        for(int c = 0 ; c < n ; c++){
            dp[m - 1][c] = matrix[m - 1][c] - '0';
        }

        

        for(int r = m - 2; r >= 0 ; r--){
            for(int c = n - 2; c>= 0 ; c--){
                if(matrix[r][c] == '0'){
                    dp[r][c] = 0;
                }
                else{
                    dp[r][c] = 1 + Math.min(dp[r+1][c],Math.min(dp[r][c+1],dp[r+1][c+1]));
                }
            }
        }

        for(int r = 0 ; r < m; r++){
            for(int c = 0 ; c < n ; c++){
                maxLength = Math.max(maxLength,dp[r][c]);
            }
        }

        return maxLength * maxLength;

        
    }
}
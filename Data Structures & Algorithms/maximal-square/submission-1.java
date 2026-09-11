class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];

        int maxLength = 0;

        for(int r = m - 1 ; r >= 0 ; r--){
            for(int c = n - 1; c >= 0 ; c--){
                if(matrix[r][c] == '1'){
                    dp[r][c] = 1 + Math.min(dp[r+1][c],Math.min(dp[r][c+1],dp[r+1][c+1]));
                }

                maxLength = Math.max(maxLength , dp[r][c]);
            }
        }

        return maxLength * maxLength;
    }

}
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];

        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        dp[0][0] = 1;

        for(int r = 1 ; r < rows ; r++ ){
            if(obstacleGrid[r][0] == 0){
                dp[r][0] = dp[r - 1][0];
            }
        }

        for(int c = 1 ; c < cols ; c++){
            if(obstacleGrid[0][c] == 0){
                dp[0][c] = dp[0][c - 1];
            }
        }

        for(int r = 1 ; r < rows; r++){
            for(int c = 1 ; c < cols ; c++){
                if(obstacleGrid[r][c] == 1){
                    dp[r][c] = 0;
                }
                else{
                    dp[r][c] = dp[r - 1 ][c] + dp[r][c - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
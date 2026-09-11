class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][i] = 1;
        }

        for(int left = n - 1 ; left >= 0 ; left--){
            for(int right = left + 1; right < n ; right ++){
                if(s.charAt(left) == s.charAt(right)){
                    dp[left][right] = 2 + dp[left + 1][right - 1];
                }
                else{
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }

        return dp[0][n - 1];

    }
}
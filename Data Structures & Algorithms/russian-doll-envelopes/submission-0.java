class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)-> a[0] - b[0]);
        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int maxEnv  = 1;

        for(int i = len - 2 ; i >= 0 ; i--){
            int[] env = envelopes[i];
            int curr_width = env[0];
            int curr_height = env[1];

            for(int j = i + 1; j < len ; j++){
                int[] next = envelopes[j];
                int next_width = next[0];
                int next_height = next[1];

                if(curr_width < next_width && 
                   curr_height < next_height &&
                   1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }

            maxEnv = Math.max(maxEnv,dp[i]);
            
        }

        return maxEnv;
        
    }
}
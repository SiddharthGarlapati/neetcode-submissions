class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int i = n-1 ; i >= 0 ; i--){
            for( String word : wordDict){
                int w_len = word.length();
                if(i + w_len <= n && 
                s.substring(i, i + w_len).equals(word)){
                    if(dp[i + w_len]){
                        dp[i] = true;
                        break;
                    }

                }
            }
        }

        return dp[0];
        
    }
}

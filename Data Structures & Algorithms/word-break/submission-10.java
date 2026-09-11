class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for(int start = n - 1 ; start >= 0 ; start--){
            for(int end = start + 1; end <= n ; end++){
                String word = s.substring(start,end);
                if(set.contains(word) && dp[end]){
                    dp[start] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}

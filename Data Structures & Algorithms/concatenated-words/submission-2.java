class Solution {
    Set<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());

        for(String word: words){
            boolean[] dp = new boolean[word.length() + 1];
            if(canForm(word,dp)){
                res.add(word);
            }

            set.add(word);
                
        }
        
        return res;
    }

    private boolean canForm(String word, boolean[] dp){
        int n = word.length();
        dp[n] = true;

        for(int start = n - 1 ; start >= 0 ; start--){
            for(int end = start + 1 ; end <= n ; end++){
               String str = word.substring(start, end);
               if(set.contains(str) && dp[end]){
                    dp[start] = true;
                    break;
               }
            }
        }

        return dp[0];
    }
}
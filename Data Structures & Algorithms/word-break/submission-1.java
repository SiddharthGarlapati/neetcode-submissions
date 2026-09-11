class Solution {
    Set<String> set;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        set = new HashSet<>();
        memo = new Boolean[n];

        for(String word: wordDict){
            set.add(word);
        }

        return dfs(0,s);
    }

    private boolean dfs(int start, String s){
        if(start == s.length()){
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        for(int end = start + 1 ; end <= s.length() ; end++){
            String str = s.substring(start,end);

            if(set.contains(str) && dfs(end,s)){
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}

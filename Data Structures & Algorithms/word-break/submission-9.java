class Solution {
    Set<String> set;
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        return dfs(0,s);
    }

    private boolean dfs(int index , String s){
        if(index == s.length()){
            return true;
        }

        if(memo[index] != null){
            return memo[index];
        }

        for(int i = index; i < s.length(); i++){
            String word = s.substring(index, i + 1);
            if(set.contains(word) && dfs(i+1,s)){
                memo[index] =  true;
                return memo[index];
            }
        }

        memo[index] = false;
        return memo[index];
    }
}

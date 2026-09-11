class Solution {
    Boolean[] memo;
    Set<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a,b)-> a.length() - b.length());
        List<String> res = new ArrayList<>();
        set = new HashSet<>();

        for(String word: words){
            memo = new Boolean[word.length()];
            if(dfs(word,0)){
                res.add(word);
            }

            set.add(word);
            
        }

        return res;
        
    }

    private boolean dfs(String word, int start){
        if(start == word.length()){
            return true;
        }

        if(memo[start] != null){
            return memo[start];
        }

        for(int end = start + 1 ; end <= word.length() ; end++){
            String str = word.substring(start,end);

            if(set.contains(str)){
                if(dfs(word,end)){
                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }
}
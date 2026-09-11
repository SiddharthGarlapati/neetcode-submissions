class Solution {
    Set<String> set;
    Map<Integer,List<String>> memo;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new HashMap<>();

        return dfs(0,s);
    }

    private List<String> dfs(int start, String s){
        List<String> res = new ArrayList<>();
        if(start == s.length()){
            res.add("");
            return res;
        }

        if(memo.containsKey(start)){
            return memo.get(start);
        }

        for(int end = start + 1 ; end <= s.length() ; end++){
            String str = s.substring(start,end);

            if(set.contains(str)){
                List<String> nextList = dfs(end,s);

                for(String next: nextList){
                    if(next.length() == 0){
                        res.add(str);
                    }
                    else{
                        res.add(str + " " + next);
                    }
                }
            }
        }

        memo.put(start,res);
        return memo.get(start);
    }
}
class Solution {
    Set<String> set;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        res = new ArrayList<>();

        List<String> list = new ArrayList<>();

        dfs(0,s,list);
        return res;
    }

    private void dfs(int start,String s, List<String> list){
        if(start == s.length()){
            res.add(String.join(" ",list));
            return;
        }

        for(int end = start + 1 ; end <= s.length() ; end++){
            String str = s.substring(start,end);

            if(set.contains(str)){
                list.add(str);
                dfs(end,s,list);
                list.remove(list.size() - 1);
            }
        }

    }
}
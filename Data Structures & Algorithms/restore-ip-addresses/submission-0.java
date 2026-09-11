class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        dfs(0,s,list);

        return res;
    }

    private void dfs(int start, String s, List<String> list){
        if(list.size() == 4 && start == s.length()){
            res.add(String.join(".",list));
            return;
        }

        if(list.size() == 4 || start == s.length()){
            return;
        }

        for(int end = start; end < s.length() && end < start + 3 ; end++){
            String part = s.substring(start,end + 1);
            if(isValid(part)){
                list.add(part);
                dfs(end + 1,s, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValid(String part){
        if(part.length() > 1 && part.charAt(0) == '0'){
            return false;
        }

        int ans = 0; 
        for(int i = 0 ; i < part.length(); i++){
            int digit = part.charAt(i) - '0';
            ans = ans * 10 + digit;
        }

        return (ans >= 0 && ans <= 255);
    }
}
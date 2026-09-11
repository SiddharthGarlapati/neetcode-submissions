class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0,0,n,sb);

        return res;
    }

    private void dfs(int open, int close, int n,StringBuilder sb){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            dfs(open + 1 , close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(open > close){
            sb.append(')');
            dfs(open , close + 1, n , sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

class Solution {
    Boolean[][] memo;
    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n+1][n+1];
        return dfs(0,0,s);
        
        
    }

    private boolean dfs(int i , int count, String s){

        if(count < 0 ) return false;

        if(i == s.length()) return count == 0;

        if(memo[i][count] != null) return memo[i][count];

        boolean ans;

        if(s.charAt(i) == '('){
            ans =  dfs(i+1, count + 1, s);
        }
        else if(s.charAt(i) == ')'){
            ans  = dfs(i+1, count - 1, s);
        }
        else{
           ans =   dfs(i+1, count, s) ||
                   dfs(i+1, count + 1, s) ||
                   dfs(i+1, count - 1, s);
        }

        memo[i][count] = ans;

        return memo[i][count];
    }

}

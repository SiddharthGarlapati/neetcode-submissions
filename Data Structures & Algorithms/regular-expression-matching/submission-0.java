class Solution {
    Boolean[][] memo;
    int m , n;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        memo = new Boolean[m+1][n+1];


        return dfs(0,0,s,p);
        
        
    }

    private boolean dfs(int i , int j , String s, String p){
        if(i == m && j == n) return true;
        if(j == n) return false;

        if(memo[i][j] != null) return memo[i][j];

        boolean match = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean ans ; 

        if( j + 1 < n && p.charAt(j+1) == '*'){
            boolean skipStar = dfs(i,j+2,s,p);
            boolean useStar = (match && dfs(i+1,j,s,p));
            ans = skipStar || useStar;

        }
        else{
            ans = (match && dfs(i+1,j+1,s,p));
        }

        memo[i][j] = ans;
        return memo[i][j];
    }
}

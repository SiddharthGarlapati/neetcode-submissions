class Solution {
    Integer[][] memo;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new Integer[n][n];
        
        return dfs(0, n - 1, s);
    }

    private int dfs(int left, int right, String s){

        if(left > right){
            return 0;
        }

        if(left == right){
            return 1;
        }

        if(memo[left][right] != null){
            return memo[left][right];
        }

        if(s.charAt(left) == s.charAt(right)){
            memo[left][right] = 2 + dfs(left + 1, right - 1,s);
        }
        else{
            memo[left][right] = Math.max(dfs(left, right - 1,s), dfs(left + 1 , right,s));
        }

        return memo[left][right];
    }
}
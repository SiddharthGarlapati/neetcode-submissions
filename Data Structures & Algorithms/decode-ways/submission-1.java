class Solution {
    Integer[] memo;
    public int numDecodings(String s) {
        memo = new Integer[s.length()];
        return dfs(0,s); 
    }

    private int dfs(int i , String s){
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0'){
            return 0;
        }

        if(memo[i] != null){
            return memo[i];
        }

        int count = 0;

        count += dfs(i + 1, s);

        if(i+1 < s.length()){
            int num = Integer.parseInt(s.substring(i,i+2));
            if(num >= 10 && num <= 26){
                count += dfs(i+2,s);
            }

        }

        memo[i] = count;
        return count;

    }
}

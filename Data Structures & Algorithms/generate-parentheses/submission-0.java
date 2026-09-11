class Solution {
    List<String> res;
    int count;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        count = n;

        backtrack(0,0,"");
        
        return res;
    }

    public void backtrack(int openN, int closeN, String curr){
        
        if(curr.length() == count * 2){
            res.add(curr);
        }

        if(openN < count){
            backtrack(openN + 1, closeN,curr  + "(");
        }

        if(closeN < openN){
            backtrack(openN,closeN + 1, curr + ")");
        }

    }


}

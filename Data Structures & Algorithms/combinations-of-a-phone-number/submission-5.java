class Solution {

    List<String> res;
    String[] map = {
        "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();

        if(digits.length() == 0){
            return res;
        }

        StringBuilder sb = new StringBuilder();

        dfs(0, digits, sb);

        return res;

        
    }

    private void dfs(int i , String digits,StringBuilder sb){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }

        String letters = map[digits.charAt(i) - '0'];

        for(int c = 0 ; c < letters.length() ; c++){
            sb.append(letters.charAt(c));
            dfs(i+1, digits,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution {
    List<String> res = new ArrayList<>();
    String[] map = {"", "", "abc","def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String d; 
    public List<String> letterCombinations(String digits) {
        d = digits;
        String str = "";

        if(digits.length() == 0 || digits == null) return res; 

        backtrack(0,str);

        return res;

        
    }
    

    public void backtrack(int index , String str){
        if(index == d.length()){
            res.add(str);
            return;
        }
        
        String temp = map[d.charAt(index) - '0'];
        for(int i = 0 ; i < temp.length(); i++){
            backtrack(index + 1 , str + temp.charAt(i));
        }
    }
}

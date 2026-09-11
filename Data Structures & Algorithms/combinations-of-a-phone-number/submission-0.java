class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, String> map;
    String d; 
    public List<String> letterCombinations(String digits) {
        map  = new HashMap<>();
        d = digits;
    
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4', "ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9',"wxyz");

        String str = "";

        if(digits.length() == 0) return res; 

        backtrack(0,str);

        return res;

        
    }
    

    public void backtrack(int index , String str){
        if(index == d.length()){
            res.add(str);
            return;
        }
        
        String temp = map.get(d.charAt(index));
        for(int i = 0 ; i < temp.length(); i++){
            backtrack(index + 1 , str + temp.charAt(i));
        }
    }
}

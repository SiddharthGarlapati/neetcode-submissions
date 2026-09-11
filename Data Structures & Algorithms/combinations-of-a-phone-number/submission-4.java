class Solution {

    List<String> res;
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {


        res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        StringBuilder sb = new StringBuilder();
        dfs(0,digits, sb);

        return res;
        
    }

    private void dfs(int i ,String digits,StringBuilder sb){

        if(sb.length() == digits.length()){
            res.add(new String(sb));
            return;
        }

        String letters = map.get(digits.charAt(i));

        for(int c = 0 ; c < letters.length(); c++){
            sb.append(letters.charAt(c));
            dfs(i + 1,digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}

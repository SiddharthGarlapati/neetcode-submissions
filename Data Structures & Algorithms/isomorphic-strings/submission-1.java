class Solution {
    public boolean isIsomorphic(String s, String t) {

        Map<Character,Character> sToT = new HashMap<>();
        Map<Character,Character> tToS = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(sToT.containsKey(ch1) && sToT.get(ch1) != ch2){
                return false;
            }

            if(tToS.containsKey(ch2) && tToS.get(ch2) != ch1){
                return false;
            }
            

            sToT.put(ch1,ch2);
            tToS.put(ch2,ch1);
        }

        return true;
        
    }
}
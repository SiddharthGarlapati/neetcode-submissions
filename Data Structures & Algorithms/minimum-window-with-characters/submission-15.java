class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n){
            return "";
        }
        HashMap<Character,Integer> sCount = new HashMap<>();
        HashMap<Character,Integer> tCount = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i++){
            char ch = t.charAt(i);
            tCount.put(ch, tCount.getOrDefault(ch,0) + 1);
        }

        int left = 0;
        int have = 0;
        int need = tCount.size();
        int resL = -1;
        int resR = -1;
        int resLength = Integer.MAX_VALUE;
        
        for(int right = 0; right < s.length() ; right++){
            char ch = s.charAt(right);

            sCount.put(ch, sCount.getOrDefault(ch,0) + 1);

            if(sCount.get(ch).intValue() == tCount.getOrDefault(ch,0).intValue() ){
                have++;
            }

            while(have == need){
                if(resLength > (right - left + 1)){
                    resLength = right - left + 1;
                    resL = left;
                    resR = right;
                }

                char leftChar = s.charAt(left);

                if(tCount.containsKey(leftChar) && sCount.get(leftChar).intValue() == tCount.getOrDefault(leftChar, 0).intValue() ){
                    have--;
                }

                sCount.put(leftChar, sCount.get(leftChar) - 1);
                left++;
            }

        }


        return (resLength != Integer.MAX_VALUE) ? s.substring(resL,resR + 1) : "";        
    }
}

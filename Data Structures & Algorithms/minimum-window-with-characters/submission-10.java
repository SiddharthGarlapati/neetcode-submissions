class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if( n  > m ){
            return "";
        }

        Map<Character,Integer> sCount = new HashMap<>();
        Map<Character,Integer> tCount = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            char ch = t.charAt(i);
            tCount.put(ch, tCount.getOrDefault(ch,0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int resL = -1;
        int resR = -1;
        int left = 0;
        int have = 0;
        int need = tCount.size();

        for(int right = 0; right < m ; right++ ){
            char rightChar = s.charAt(right);
            sCount.put(rightChar, sCount.getOrDefault(rightChar,0) + 1);

            if(sCount.get(rightChar) == tCount.getOrDefault(rightChar,0)){
                have++;
            }

            while(have == need){
                if(minLen > right - left + 1){
                    minLen =  right - left + 1;
                    resL = left;
                    resR = right;

                }


                char leftChar = s.charAt(left);

                if(sCount.get(leftChar) == tCount.getOrDefault(leftChar,0)){
                    have--;
                }

                sCount.put(leftChar, sCount.get(leftChar) - 1);
                left++;
            }

        }


        return minLen != Integer.MAX_VALUE ? s.substring(resL,resR + 1) : "";



        
    }
}

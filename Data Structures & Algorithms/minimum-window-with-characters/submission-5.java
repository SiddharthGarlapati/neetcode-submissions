class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(n > m || t.equals("")){
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        int resL = -1;
        int resR = -1;

        int left = 0 ;

        Map<Character,Integer> sCount = new HashMap<>();
        Map<Character,Integer> tCount = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i),0) + 1 );
        }

        int have = 0;
        int need = tCount.size();

        for(int right = 0 ; right < m ; right++){
            char r = s.charAt(right);
            sCount.put(r,sCount.getOrDefault(r,0) + 1 );

            if(sCount.get(r) == tCount.getOrDefault(r,0)){
                have++;
            }

            while(have == need){

                if((right - left + 1) < minLen){
                    minLen = right - left + 1;
                    resL = left;
                    resR = right;
                }

                char l = s.charAt(left);

                if(sCount.get(l) == tCount.getOrDefault(l,0)){
                    have--;
                }
 
                sCount.put(l,sCount.get(l) - 1);
                left++;

            }
        }

        return minLen != Integer.MAX_VALUE ? s.substring(resL,resR + 1) : "";
    }
}

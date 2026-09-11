class Solution {
    public String minWindow(String s, String t) {
        if(t.equals("")) return "";
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();

        for(char c: t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c,0) + 1);
        }

        int l = 0;
        int have = 0 , need = tmap.size();
        int resLen = Integer.MAX_VALUE;
        int resL = 0; 
        int resR = 0;

        for( int r = 0 ;  r < s.length(); r++){
            char ch = s.charAt(r);

            if(tmap.containsKey(ch)){
                smap.put(ch, smap.getOrDefault(ch,0) + 1);
                if(smap.get(ch) == tmap.get(ch)) have++;
            }

            while(have == need){
                if(( r - l + 1) < resLen){
                    resLen = r - l+1;
                    resL = l;
                    resR = r;
                }

                char leftchar = s.charAt(l);

                if (tmap.containsKey(leftchar)){
                     smap.put(leftchar, smap.get(leftchar) - 1 );
                     if(smap.get(leftchar) < tmap.get(leftchar)){
                        have--;
                     }

                }

                l++;


            }


        }

        return  resLen == Integer.MAX_VALUE? "":s.substring(resL,resR+1);
        
    }
}

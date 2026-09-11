class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character,Integer> map = new HashMap<>();

        int l = 0;
        int res = 0;

        for( int  r = 0; r < s.length(); r++){
            char c = s.charAt(r);    
            map.put(c, map.getOrDefault(c, 0) + 1);

            int max_freq = getMax(map);

            while( (r - l + 1) - max_freq > k){
                char ch = s.charAt(l);
                map.put(ch, map.get(ch) - 1);
                l++;
            }


            res = Math.max(r - l + 1, res);

        }

        return res;

    

    }

    private int getMax(Map<Character,Integer> map){
        int max = 0;
        for(int value : map.values()){
            max = Math.max(value,max);
        }

        return max;
    }
}

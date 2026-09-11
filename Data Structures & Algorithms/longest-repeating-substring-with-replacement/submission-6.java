class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxf = 0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        

        for(int right = 0; right < n ; right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0) + 1);
            int freq = map.get(ch);
            if(freq > maxf){
                maxf = freq;
            }

            while((right - left + 1) - maxf > k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar) - 1);
                left++;
            }

            res = Math.max(res,right - left + 1);

        }

        return res;
        
    }
}

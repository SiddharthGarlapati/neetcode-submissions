class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];
            for(int i = 0 ; i < s.length();i++){
                char ch = s.charAt(i);
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < 26; i++){
                    sb.append(count[i]).append('#');
            }

            String code = sb.toString();

            map.putIfAbsent(code, new ArrayList<>());

            map.get(code).add(s);

        }

        return new ArrayList<>(map.values());
        
    }
}

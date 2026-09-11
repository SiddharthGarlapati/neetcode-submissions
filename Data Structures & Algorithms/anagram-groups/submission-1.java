class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i = 0 ; i < count.length ; i++){
                if(count[i] > 0){
                    key.append((char)('a' + i));
                    key.append(count[i]);
                }
            }

            String keyStr = key.toString();
            map.putIfAbsent(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {

        int n = s.length();
        int i = 0;
        int j = 0;
        List<String> words = new ArrayList<>();

        while(j < n){
            while(j < n && s.charAt(j) != ' '){
                j++;
            }

            words.add(s.substring(i,j));
            i = j+1;
            j++;
        }

        if(pattern.length() != words.size()){
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(int p = 0 ; p < pattern.length(); p++){
            char ch = pattern.charAt(p);
            String word = words.get(p);

            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                if(set.contains(word)){
                    return false;
                }
            }

            map.put(ch, word);
            set.add(word);
        }


        return true;

        
    }
}
class Solution {
    Map<Character, Set<Character>> adj;
    int[] visited = new int[26];
    StringBuilder res = new StringBuilder();
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for(String word: words){
            for(char c: word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i = 0 ; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            int l1 = w1.length();
            int l2 = w2.length();
            int minLen = Math.min(l1, l2);
            if(l1 > l2 &&  w1.substring(0,minLen).equals(w2.substring(0,minLen))){
                return "";
            }

            for(int j = 0 ; j < minLen ; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for( char c: adj.keySet()){
            if(dfs(c)) return "";
        }        

        return res.reverse().toString();
      
    }

    public boolean dfs(char c){

        int ch = c - 'a';

        if(visited[ch] == 1){
            return true;
        }

        if(visited[ch] == 2){
            return false;
        }

        visited[ch] = 1;

        for(char nei: adj.get(c)){
            if(dfs(nei)) return true;
        }

        visited[ch] = 2;

        res.append(c);

        return false;
    }
}

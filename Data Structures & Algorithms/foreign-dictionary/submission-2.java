class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,List<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for(String word : words){
        for(int i = 0 ; i < word.length() ; i++){
            adj.putIfAbsent(word.charAt(i), new ArrayList<>());
            indegree.putIfAbsent(word.charAt(i),0);
        }
      }

      for(int i = 0 ; i < words.length - 1 ; i++){
        String w1 = words[i];
        String w2 = words[i+1];
        int length = Math.min(w1.length(), w2.length());
        if(w1.length() > w2.length() && w1.startsWith(w2)){
            return "";
        }
        for(int c = 0; c < length ; c++){
            char ch1 = w1.charAt(c);
            char ch2 = w2.charAt(c);
            if(ch1 != ch2){
                if(!adj.get(ch1).contains(ch2)){
                    adj.get(ch1).add(ch2);
                    indegree.put(ch2, indegree.get(ch2) + 1);
                }
                break;
            }
        }
      }

      Queue<Character> q = new ArrayDeque<>();
      for(char ch : indegree.keySet()){
        if(indegree.get(ch) == 0){
            q.offer(ch);
        }
      }

      StringBuilder sb = new StringBuilder();

      while(!q.isEmpty()){
        char curr = q.poll();
        sb.append(curr);
        for(char nei : adj.get(curr)){
            indegree.put(nei,indegree.get(nei) - 1);
            if(indegree.get(nei) == 0){
                q.offer(nei);
            }
        }

      }

      if(sb.length() != indegree.size()){
        return "";
      }

      return sb.toString();

    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();

        Queue<String> q = new ArrayDeque<>();

        int level = 1;

        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){

                String word = q.poll();

                if(word.equals(endWord)) return level;

                char[] temp = word.toCharArray();
                
                for(int j = 0; j < temp.length; j++){
                    char original = temp[j];

                    for(char ch = 'a' ; ch <= 'z'; ch++){
                        temp[j] = ch;

                        String newWord = new String(temp);
                        if(wordList.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }   

                    temp[j] = original;   
                }

            }

            level++;

        }

        return 0;
        
    }
}

class Solution {
    Set<String> wordSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int transforms = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return transforms;
                }
                
                char[] arr = curr.toCharArray();
                for(int c = 0 ; c < arr.length ; c++){
                    char original = arr[c];

                    for(char ch = 'a' ; ch <= 'z' ; ch++){
                        if(ch == original){
                            continue;
                        }

                        arr[c] = ch;
                        String temp = new String(arr);
                        if(wordSet.contains(temp) && !visited.contains(temp)){
                            visited.add(temp);
                            q.offer(temp);
                        }
                    }
                    arr[c] = original;
                }

            }
            transforms++;
        }

        return 0;
        
    }

}

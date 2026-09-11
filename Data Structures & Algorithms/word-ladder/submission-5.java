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

                for(String s : getTransforms(curr)){
                    if(!visited.contains(s)){
                        visited.add(s);
                        q.offer(s);
                    }
                }

            }
            transforms++;
        }

        return 0;
        
    }

    private List<String> getTransforms(String curr){

        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < curr.length(); i++){
            char[] arr = curr.toCharArray();
            char original = arr[i];
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                arr[i] = ch;
                if(ch == original){
                    continue;
                }
                String temp = new String(arr);
                if(wordSet.contains(temp)){
                    res.add(temp);
                }
            }
        }

        return res;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for(String s : deadends){
            visited.add(s);
        }

        if(visited.contains("0000")){
            return -1;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        visited.add("0000");
        int turns = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                String curr = q.poll();

                if(curr.equals(target)){
                    return turns;
                }

                for(String s : getCombinations(curr)){
                    if(!visited.contains(s)){
                        visited.add(s);
                        q.offer(s);
                    }
                }

            }

            turns++;
        }

        return -1;

    }

    private List<String> getCombinations(String curr){
        List<String> res = new ArrayList<>();

        for(int i = 0 ; i < 4 ; i++){
            char[] arr = curr.toCharArray();

            char ch = arr[i];

            arr[i] = (ch == '9') ? '0' : (char)(ch + 1);
            res.add(new String(arr));

            arr[i] = (ch == '0') ? '9': (char)(ch - 1);
            res.add(new String(arr));

        }

        return res;
    }
}
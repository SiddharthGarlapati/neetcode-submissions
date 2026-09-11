class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        List<Set<Integer>> pre = new ArrayList<>();

        for(int i = 0 ; i < numCourses ; i++){
            adj.put(i , new ArrayList<>());
            pre.add(new HashSet<>());
        }

        for(int[] prereq : prerequisites){
            int u = prereq[0];
            int v = prereq[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int nei: adj.get(curr)){
                indegree[nei]--;
                pre.get(nei).add(curr);
                pre.get(nei).addAll(pre.get(curr));
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        for(int[] query : queries){
            int u = query[0];
            int v = query[1];

            res.add(pre.get(v).contains(u));
        }

        return res;
    }
}
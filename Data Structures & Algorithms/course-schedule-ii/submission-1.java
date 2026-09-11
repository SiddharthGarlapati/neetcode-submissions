class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            int course = prereq[0];
            int pre = prereq[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0 ; i < numCourses ; i++){
             if(indegree[i] == 0){
                q.offer(i);
             }
        }

        int[] res = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            res[index++] = curr;

            for(int nei : adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        if(index != numCourses){
            return new int[]{};
        }

        return res;
        
    }
}

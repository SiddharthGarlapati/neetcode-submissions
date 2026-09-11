class Solution {
    Map<Integer,List<Integer>> adj;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        visited = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            int u = prereq[0];
            int v = prereq[1];
            adj.get(v).add(u);

        }
        
        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                if(hasCycle(i)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(int i){
        if(visited[i] == 1){
            return true;
        }

        if(visited[i] == 2){
            return false;
        }

        visited[i] = 1;

        for(int nei : adj.get(i)){
            if(hasCycle(nei)){
                return true;
            }
        }

        visited[i] = 2;

        return false;
    }
}

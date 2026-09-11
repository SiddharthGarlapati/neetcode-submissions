class Solution {
    Map<Integer, List<Integer>> adj;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        adj = new HashMap<>();

        visited = new int[numCourses];

        for( int i = 0 ; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] temp : prerequisites){
            adj.get(temp[1]).add(temp[0]);
        }

        for(int i = 0 ; i < numCourses ; i++){
            if(hasCycle(i)) return false;
        }

        return true;


        
    }

    private boolean hasCycle(int i ){
        if(visited[i] == 1){
            return true;
        }
        if(visited[i] == 2){
            return false;
        }

        visited[i] = 1;
        for(int temp : adj.get(i)){
            if(hasCycle(temp)) return true;
        }

        visited[i] = 2;

        return false;
    }
}

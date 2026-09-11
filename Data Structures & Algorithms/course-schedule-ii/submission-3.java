class Solution {
    Map<Integer,List<Integer>> adj;
    int index;
    int[] res;
    int[] visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        index = 0;
        res = new int[numCourses];
        visited = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            int course = prereq[0];
            int pre = prereq[1];

            adj.get(course).add(pre);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(hasCycle(i)){
                return new int[]{};
            }
        }

        return res;

    }

    private boolean hasCycle(int i){
        if(visited[i] == 1){
            return true;
        }

        if(visited[i] == 2){
            return false;
        }

        visited[i] = 1;

        for(int prereq : adj.get(i)){
            if(hasCycle(prereq)){
                return true;
            }
        }

        visited[i] = 2;
        res[index++] = i;
        return false;
    }
}

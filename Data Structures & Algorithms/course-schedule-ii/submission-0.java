class Solution {
    Map<Integer, List<Integer>> prereqs;
    int[] visited;
    int[] result;
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        prereqs = new HashMap<>();
        visited = new int[numCourses];
        result = new int[numCourses];

        for(int i = 0 ; i < numCourses; i++){
            prereqs.put(i,new ArrayList<>());
        }

        for(int[] temp : prerequisites){
            int course = temp[0];
            int prereq = temp[1];
            prereqs.get(course).add(prereq);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(dfs(i)){
                return new int[]{};
            }
        }
        
        return result;
    }

    private boolean dfs(int i){
        if(visited[i] == 1) return true;

        if(visited[i] == 2) return false;


        visited[i] = 1;

        for(int x : prereqs.get(i)){
            if(dfs(x)){
                return true;
            }
        }

        visited[i] = 2;
        result[index] = i;
        index++;

        return false;
    }
}

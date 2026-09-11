class Solution {

    Map<Integer, List<Integer>> adj;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        adj = new HashMap<>();
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            adj.put(i,new ArrayList<>());
        
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for( int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                count++;
                dfs(i);
            }
        }

        return count;


    }

    private void dfs(int i){

        visited[i] = true;

        for(int nei: adj.get(i)){
            if(visited[nei] == false){
                dfs(nei);
            }
        }

    }

}

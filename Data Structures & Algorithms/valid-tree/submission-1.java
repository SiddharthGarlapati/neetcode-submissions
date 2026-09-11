class Solution {
    Map<Integer, List<Integer>> adj;
    boolean[] visited;
    public boolean validTree(int n, int[][] edges) {
        adj = new HashMap<>();
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        if(hasCycle(0,-1)){
            return false;
        }

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == false){
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int i, int parent){
        if(visited[i]){
            return true;
        }

        visited[i] = true;

        for(int nei : adj.get(i)){
            if(nei == parent){
                continue;
            }
            if(hasCycle(nei,i)){
                return true;
            }
        }

        return false;
    }
}

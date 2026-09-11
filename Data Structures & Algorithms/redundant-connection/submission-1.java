class Solution {
    Map<Integer,List<Integer>> adj;
    public int[] findRedundantConnection(int[][] edges) {
        adj = new HashMap<>();

        int n = edges.length;

        for(int i = 0 ; i <= n ; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            boolean[] visited = new boolean[n + 1];

            if(hasCycle(u,-1,visited)){
                return edge;
            }
        }

        return new int[]{};
    }

    private boolean hasCycle(int i , int parent , boolean[] visited){
        if(visited[i]){
            return true;
        }

        visited[i] = true;

        for(int nei : adj.getOrDefault(i, new ArrayList<>())){
            if(nei == parent){
                continue;
            }
            if(hasCycle(nei,i,visited)){
                return true;
            }
        }

        return false;
    }
}

class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            int rootU = find(u);
            int rootV = find(v);

            if(rootU == rootV) return edge;

            parent[rootV] = rootU;

        }      

        return new int[]{};  

    }

    private int find(int u){
        if(parent[u] != u){
            parent[u] = find(parent[u]);
        }

        return parent[u];
    }
}

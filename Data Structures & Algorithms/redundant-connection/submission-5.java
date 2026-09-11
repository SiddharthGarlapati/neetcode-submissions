class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i = 1; i <= n ; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int rootU = find(u);
            int rootV = find(v);
            if(rootU == rootV){
                return edge;
            }

            parent[rootV] = rootU;
        }

        return new int[0];


    }

    private int find(int n){
        if(n != parent[n]){
            parent[n] = find(parent[n]);
        }

        return parent[n];
    }
}

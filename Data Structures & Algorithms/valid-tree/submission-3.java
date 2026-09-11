class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        int components = n;

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int rootU = find(u);
            int rootV = find(v);
            if(rootU == rootV){
                return false;
            }

            parent[rootV] = rootU;
            components--;
        }

        return (components == 1);
    }

    private int find(int n){
        if(n != parent[n]){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
}

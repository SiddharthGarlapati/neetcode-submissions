class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for(int i = 0; i < n ; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(find(u) != find(v)){
                union(u,v);
                n--;
            }
        }

        return n;


    }

    private int find(int n ){
        if(parent[n] != n){
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    private void union(int u , int v){
        int rootU = find(u);
        int rootV = find(v);
        if(rank[rootU] >= rank[rootV]){
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        else{
            parent[rootU] = rootV;
            rank[rootV]++;
        }
    }
}

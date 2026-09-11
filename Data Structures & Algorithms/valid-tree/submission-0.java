class Solution {

    Map<Integer,List<Integer>> adj;
    boolean[] visited;
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1) return false;
        adj = new HashMap<>();
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0,-1)) return false;

        int count = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(visited[i]){
                count++;
            }
        }

        return (count == n);

    }

    private boolean dfs(int i,int parent){

        if(visited[i] == true){
            return false;
        }

        visited[i] = true;

        for( int nei: adj.get(i)){
            if(nei == parent) continue;
            if(!dfs(nei, i)) return false;
        }

        return true;      

    }

}

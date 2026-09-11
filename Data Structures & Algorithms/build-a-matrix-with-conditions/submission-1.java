class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];

        List<Integer> rowOrder = topoSort(k,rowConditions); 
        List<Integer> colOrder = topoSort(k,colConditions);

        if(rowOrder.size() != k || colOrder.size() != k){
            return new int[0][0];
        }

        int[] rowPos = new int[k+1];
        int[] colPos = new int[k+1];

        for(int i = 0 ; i < k ; i++){
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        for(int i = 1 ; i <= k ; i++){
            int row = rowPos[i];
            int col = colPos[i];
            matrix[row][col] = i;
        }

        return matrix;
    }

    private List<Integer> topoSort(int k , int[][] conditions){

        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[k+1];
        for(int i = 1 ; i <= k ; i++){
            adj.put(i, new ArrayList<>());
        }

        for(int[] condition : conditions){
            int u = condition[0];
            int v = condition[1];
            if(!adj.get(u).contains(v)){
                adj.get(u).add(v);
                indegree[v]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 1 ; i <= k ; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            order.add(curr);

            for(int nei : adj.get(curr)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }

        return order;
    }


}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        int totalCost = 0;

        for(int i = 0 ; i < n ; i++){
            int currNode = -1;
            int currDist = Integer.MAX_VALUE;


            for(int j = 0 ; j < n ; j++){
                if(!visited[j] && dist[j] < currDist){
                    currDist = dist[j];
                    currNode = j;
                }
            }

            visited[currNode] = true;
            totalCost += currDist;

            for(int nei = 0 ; nei < n ; nei++){
                if(!visited[nei]){
                    int cost = Math.abs(points[currNode][0] -  points[nei][0]) +
                    Math.abs(points[currNode][1] - points[nei][1]);

                    if(cost < dist[nei]){
                        dist[nei] = cost;
                    }     
                }                  
                
            }



        }

        return totalCost;

    }
}

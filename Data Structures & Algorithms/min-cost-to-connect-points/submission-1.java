class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        Map<Integer,List<int[]>> graph = new HashMap<>();

        for(int i = 0 ; i < n ; i++ ){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for( int j = i + 1; j < n ; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 -x2) + Math.abs(y1 -y2);
                graph.putIfAbsent(i, new ArrayList<>());
                graph.putIfAbsent(j, new ArrayList<>());

                graph.get(i).add(new int[]{dist,j});
                graph.get(j).add(new int[]{dist,i});

            }
        }

        Set<Integer> visit = new HashSet<>();
        int cost = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0,0});

        while (visit.size() < n){
            int[] curr = minHeap.poll();
            int currDist = curr[0];
            int currNode = curr[1];

            if(visit.contains(currNode)) continue;
            
            visit.add(currNode);

            cost += currDist;

            for(int[] nei : graph.getOrDefault(currNode, new ArrayList<>())){
                int neiDist = nei[0];
                int neiNode = nei[1];

                if(!visit.contains(neiNode)){
                    minHeap.offer(new int[]{neiDist,neiNode});
                }

            }


        }

        return cost;
        
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u,new ArrayList<>());
            graph.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        min_heap.offer(new int[]{0,k});

        while(!min_heap.isEmpty()){
            int[] curr = min_heap.poll();

           int currTime = curr[0];
           int currNode = curr[1];

            if(currTime > dist[currNode]) continue;

            for(int[] edge: graph.getOrDefault(currNode, new ArrayList<>())){
                int nei = edge[0];
                int weight = edge[1];

                int newTime = currTime + weight;

                if(newTime < dist[nei]){
                    dist[nei] = newTime;
                    min_heap.offer(new int[]{newTime,nei});
                }
            }

        }

        int res = 0 ;

        for(int i = 1; i <= n ; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;

            res = Math.max(res,dist[i]);
        }

        return res;


        
    }
}

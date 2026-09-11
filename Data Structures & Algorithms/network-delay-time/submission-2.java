class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            adj.put(i, new ArrayList<>());
        }

        boolean[] visited = new boolean[n+1];

        for(int[] time: times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        minHeap.offer(new int[]{k,0});
        int time = 0;
        int count = 0;

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int node = curr[0];
            int weight = curr[1];
            if(visited[node]){
                continue;
            }
            time = weight;
            visited[node] = true;
            count++;

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int next_weight = nei[1];
                if(!visited[next]){
                    minHeap.offer(new int[]{next, weight + next_weight});
                }
            }
        }

        return (count == n) ? time : -1;

    }
}

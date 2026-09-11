class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src] = 0;
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adj.get(u).add(new int[]{v,w});
        } 

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{src,0,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int price = curr[1];
            int stops = curr[2];
            if(stops > k){
                continue;
            }

            for(int[] nei: adj.get(node)){
                int neiNode = nei[0];
                int neiPrice = nei[1];
                
                int newPrice = price + neiPrice;
                if( newPrice < prices[neiNode]){
                    prices[neiNode] = newPrice;
                    q.offer(new int[]{neiNode, newPrice , stops + 1});
                }


            }
        }

        return (prices[dst] != Integer.MAX_VALUE ) ? prices[dst] : -1;

    }
}

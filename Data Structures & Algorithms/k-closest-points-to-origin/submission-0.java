class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> min_heap = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        int[][] res = new int[k][2];

        for(int i = 0 ; i < points.length ; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x * x + y * y;
            min_heap.offer(new int[]{dist,x,y});
        }

        for(int i = 0 ; i < k ; i++){
            int[] curr = min_heap.poll();
            res[i][0] = curr[1];
            res[i][1] = curr[2];
        }

        return res;   

    }
}

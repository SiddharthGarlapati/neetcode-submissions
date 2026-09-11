class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m = intervals.length;
        int n = queries.length;

        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        int[] sorted_q = queries.clone();

        Arrays.sort(sorted_q);
        int i = 0;

        Map<Integer,Integer> res = new HashMap<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        for(int q = 0 ; q < n ; q++){
            while(i < m && intervals[i][0] <= sorted_q[q]){
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;
                minHeap.offer(new int[]{length,right});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < sorted_q[q]){
                minHeap.poll();
            }
            if(!minHeap.isEmpty()){
                int[] min = minHeap.peek();
                int min_length = min[0];
                res.put(sorted_q[q],min_length);
            }
            else{
                res.put(sorted_q[q],-1);
            }
        }

        int[] output = new int[n];

        for(int j = 0 ; j < n ; j++){
            output[j] = res.get(queries[j]);
        }

        return output;

        
    }
}

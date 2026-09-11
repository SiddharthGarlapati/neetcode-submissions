class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        int passengers = 0;

        for(int[] trip : trips){
            int currPass = trip[0];
            int currStart = trip[1];
            int currEnd = trip[2];

            while(!minHeap.isEmpty() && minHeap.peek()[1] <= currStart){
                int[] temp = minHeap.poll();
                passengers -= temp[0];
            }

            passengers += currPass;
            if(passengers > capacity){
                return false;
            }
            minHeap.offer(new int[]{currPass, currEnd});

        }


        return true;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(int i = 0 ; i < tasks.length ; i++){
            count[tasks[i] - 'A']++;
        }

        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b)-> b - a);
        for(int i = 0 ; i < 26 ; i++){
            if(count[i] > 0){
                max_heap.offer(count[i]);
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;

        while(!max_heap.isEmpty() || !q.isEmpty()){
            time++;

            if(!max_heap.isEmpty()){
                int max_freq = max_heap.poll() - 1;
                if(max_freq > 0){
                    q.offer(new int[]{max_freq, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time){
                max_heap.offer(q.poll()[0]);
            }

        }

        return time;

        
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] > 0){
                maxHeap.offer(freq[i]);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;

                if(count > 0){
                    q.offer(new int[]{count, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time ){
                maxHeap.offer(q.poll()[0]);
            }

        }


        return time;

        
    }
}

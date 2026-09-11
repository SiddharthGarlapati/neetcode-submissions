class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a,b)-> b - a);
        max_heap.offer(0);

        for(int i = 0; i < stones.length; i++){
            max_heap.offer(stones[i]);
        }

        while(max_heap.size() > 1){
            int x = max_heap.poll();
            int y = max_heap.poll();
            max_heap.offer(x - y);
        }

        return max_heap.peek();


        
    }
}

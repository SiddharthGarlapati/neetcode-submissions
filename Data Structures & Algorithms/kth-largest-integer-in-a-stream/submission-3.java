class KthLargest {

    PriorityQueue<Integer> minHeap ;
    int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            minHeap.offer(nums[i]);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {

        minHeap.offer(val);

        if(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
        
    }
}

class KthLargest {

    PriorityQueue<Integer> minHeap ;
    int kth = 0;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        kth = k;
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

        if(minHeap.size() > kth){
            minHeap.poll();
        }

        return minHeap.peek();
        
    }
}

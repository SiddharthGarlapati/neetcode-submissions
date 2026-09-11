class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    

    public KthLargest(int k, int[] nums) {
        this.k = k;  
        this.pq = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }   

    }
    
    public int add(int val) {  
        pq.offer(val);
        if(pq.size() > k){
            pq.poll();
        }

        return pq.peek();

    }
}

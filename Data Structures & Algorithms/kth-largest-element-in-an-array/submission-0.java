class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length; i++){
            min_heap.offer(nums[i]);
            if(min_heap.size() > k){
                min_heap.poll();
            }
        }

        return min_heap.peek();



        
    }
}

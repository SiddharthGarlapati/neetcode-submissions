class MedianFinder {
      PriorityQueue<Integer> small_heap;
      PriorityQueue<Integer> large_heap; 

    public MedianFinder() {
        small_heap  = new PriorityQueue<>((a,b) -> b - a);
        large_heap = new PriorityQueue<>();

              
    }
    
    public void addNum(int num) {
        small_heap.add(num);

        if(!large_heap.isEmpty() && small_heap.peek() > large_heap.peek()){
            large_heap.add(small_heap.poll());

        }

        if(small_heap.size() > large_heap.size() + 1){
            large_heap.add(small_heap.poll());

        }
        if(large_heap.size() > small_heap.size() + 1){
            small_heap.add(large_heap.poll());
        }

        
    }
    
    public double findMedian() {
        if(small_heap.size() > large_heap.size()){
            return (double)small_heap.peek();
        }
        else if ( large_heap.size() > small_heap.size()){
            return (double)large_heap.peek();
        }
        else{
            return (double)(small_heap.peek() + large_heap.peek())/2;
        }
        
    }
}

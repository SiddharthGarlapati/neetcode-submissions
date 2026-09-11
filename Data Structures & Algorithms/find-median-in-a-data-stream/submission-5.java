class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)-> b - a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(small.isEmpty() || num <= small.peek()){
            small.offer(num);
        }
        else{
            large.offer(num);
        }

        if(small.size() - large.size() > 1){
            large.offer(small.poll());
        }
        
        if(small.size() < large.size()){
            small.offer(large.poll());
        }
        
    }
    
    public double findMedian() {

        if(small.size() > large.size()){
            return (double) small.peek();
        }
        else{
            return ((double)small.peek() + large.peek())/2.0;
        }
        
    }
}

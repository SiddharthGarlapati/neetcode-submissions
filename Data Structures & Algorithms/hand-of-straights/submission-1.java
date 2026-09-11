class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) return false;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        // minHeap.addAll(map.keySet());
        for(int key: map.keySet()){
            minHeap.offer(key);
        }

        while(!minHeap.isEmpty()){
            int min = minHeap.peek();

            for(int i = min ; i < min + groupSize; i++){
                if(!map.containsKey(i)) return false;
                int count = map.get(i);
                map.put(i,count - 1);
                if( map.get(i) == 0){
                    if(i != minHeap.peek()) return false;
                    minHeap.poll(); 
                }

            }
        }

        return true;
    }
}

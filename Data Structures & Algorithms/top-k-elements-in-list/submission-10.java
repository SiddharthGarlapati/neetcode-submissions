class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[1] - a[1]);

        for(int num: map.keySet()){
            maxHeap.offer(new int[]{num, map.get(num)});
        }

        int[] res = new int[k];

        for(int i = 0 ; i < k ; i++){
            int[] temp = maxHeap.poll();
            res[i] = temp[0];
        }

        return res;
    }
}

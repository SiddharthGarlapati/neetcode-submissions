class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        int[] res = new int[k];

        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> b[1] - a[1]);

        for(int num: map.keySet()){
            maxHeap.offer(new int[]{num, map.get(num)});
        }

        int i =0;

        while(!maxHeap.isEmpty() & i < k){
            res[i] = maxHeap.poll()[0];
            i++;
        }

        return  res;


        
    }
}

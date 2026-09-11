class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for(int num: map.keySet()){
            minHeap.offer(new int[]{num, map.get(num)});

            if(minHeap.size() > k ){
                minHeap.poll();
            }
        }


        for(int i = 0 ; i < k ; i++){
            res[i] = minHeap.poll()[0];
        }

        return res;

    }
}

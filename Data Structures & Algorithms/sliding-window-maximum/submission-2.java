class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        int[] res = new int[n - k + 1];

        for(int i = 0 ; i < k ; i++){
            maxHeap.offer(new int[]{nums[i],i});
        }

        res[0] = maxHeap.peek()[0];
        int idx = 1;


        for(int right = k ; right < n ; right++){

            maxHeap.offer(new int[]{nums[right],right});

            int left = right - k + 1;

            while(maxHeap.peek()[1] < left){
                maxHeap.poll();
            }

            res[idx] = maxHeap.peek()[0];
            idx++;

        }

        return res;
        
    }
}

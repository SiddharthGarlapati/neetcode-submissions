class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        int[] res = new int[n - k + 1];
        int idx = 0;

        for(int right = 0 ; right < n ; right++){
            maxHeap.offer(new int[] {nums[right], right});

            if(right >= k - 1){
                int left = right - k + 1;
                while(maxHeap.peek()[1] < left){
                    maxHeap.poll();
                }

                res[idx++] = maxHeap.peek()[0];
            }
        }

        return res;
        
    }
}

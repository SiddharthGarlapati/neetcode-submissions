class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        int[] res = new int[n - k + 1];
        int idx = 0;

        int left = 0;

        for(int right = 0 ; right < n ; right++){

            maxHeap.offer(nums[right]);

            if(right >= k ){
                maxHeap.remove(nums[left]);
                left++;
            }

            if(right >= k - 1){
                res[idx++] = maxHeap.peek();
            }

        }

        return res;
        
    }
}

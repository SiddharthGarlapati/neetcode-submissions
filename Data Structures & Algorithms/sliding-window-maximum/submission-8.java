class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int left = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        int[]res = new int[n - k + 1];
        int idx = 0;

        for(int right = 0 ; right < n ; right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);

            if(dq.peekFirst() < left){
                dq.pollFirst();
            }

            if(right >= k - 1){
                res[idx] = nums[dq.peekFirst()];
                idx++;
                left++;
            }


        }

        return res;
        
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        int outputindex = 0;

        int l = 0 ;
        int r = 0;

        while( r < nums.length){
            while(!dq.isEmpty() && nums[r] > nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.addLast(r);

            if( !dq.isEmpty() && l > dq.peekFirst()){
                dq.pollFirst();
            }

            if(r + 1 >= k){
                output[outputindex++] = nums[dq.peekFirst()];
                l++;
            }

            r++;

        }

        return output;

        
    }
}

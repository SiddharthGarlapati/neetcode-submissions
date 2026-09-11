class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();

        int maxLen = 0;
        int left = 0;

        for(int right = 0 ; right < n ; right++){
            while(!maxDq.isEmpty() && nums[right] > nums[maxDq.peekLast()]){
                maxDq.pollLast();
            }

            maxDq.offerLast(right);

            while(!minDq.isEmpty() && nums[right] < nums[minDq.peekLast()]){
                minDq.pollLast();
            }

            minDq.offerLast(right);

            while(nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > limit){
                if(maxDq.peekFirst() == left){
                    maxDq.pollFirst();
                }
                if(minDq.peekFirst() == left){
                    minDq.pollFirst();
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

        } 

        return maxLen;
    }
}
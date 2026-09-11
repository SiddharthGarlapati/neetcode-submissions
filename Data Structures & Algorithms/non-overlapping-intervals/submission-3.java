class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        int prevEnd = intervals[0][1];
        int res = 0;

        for(int i = 1 ; i < n ; i++){
            int[] interval = intervals[i];
            int currStart = interval[0];
            int currEnd = interval[1];
            if(currStart < prevEnd){
                res++;
                prevEnd = Math.min(prevEnd,currEnd);
            }
            else{
                prevEnd = currEnd;
            }
        }

        return res;
        
    }
}

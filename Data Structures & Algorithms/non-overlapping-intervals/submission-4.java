class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);

        int prevEnd = intervals[0][1];
        int res = 0;

        for(int i = 1 ; i < n ; i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart < prevEnd){
                res++;
                prevEnd = Math.min(currEnd,prevEnd);
            }
            else{
                prevEnd = currEnd;
            }
        }

        return res;
    }
}

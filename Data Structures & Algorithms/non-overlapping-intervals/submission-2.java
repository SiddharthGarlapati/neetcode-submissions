class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int prevEnd = intervals[0][1];

        int res = 0 ;

        for(int i = 1; i < intervals.length; i++){
            int currEnd = intervals[i][1];
            if(intervals[i][0] < prevEnd){
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

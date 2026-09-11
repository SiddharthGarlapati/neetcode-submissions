class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int n = intervals.length;
        int[] prev = new int[2];
        prev = intervals[0];
        List<int[]> res = new ArrayList<>();

        for(int i = 1; i < n ; i++){
            int[] curr = intervals[i];

            if(curr[0] <= prev[1]){
                prev[1] = Math.max(curr[1],prev[1]);
            }
            else{
                res.add(prev);
                prev = curr;
            }

        }

        res.add(prev);

        return res.toArray(new int[res.size()][]);
        
    }
}

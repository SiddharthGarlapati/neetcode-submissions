class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i < n ; i++){
            int[] curr = intervals[i];
            int[] prev = res.get(res.size() - 1);

            if(curr[0] <= prev[1]){
                prev[1] = Math.max(prev[1],curr[1]);
            }
            else{
                res.add(curr);
            }
        }

        return res.toArray(new int[res.size()][]);
        
    }
}

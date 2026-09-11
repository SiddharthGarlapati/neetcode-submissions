class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] minTime = new int[n+1];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        minTime[k] = 0;

        for(int i = 0 ; i < n ; i++){
            int[] temp = minTime.clone();
            for(int[] time: times){
                int u = time[0];
                int v = time[1];
                int w = time[2];

                if(minTime[u] == Integer.MAX_VALUE){
                    continue;
                }
                if(minTime[u] + w < temp[v]){
                    temp[v] = minTime[u] + w;
                }
            }

            minTime = temp;
        }

        int res = -1;

        for(int i = 1 ; i <= n ; i++){
            if(minTime[i] == Integer.MAX_VALUE){
                return -1;
            }

            res = Math.max(res, minTime[i]);

        }

        return res;
    }
}

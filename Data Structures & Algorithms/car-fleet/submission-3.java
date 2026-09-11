class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int carFleets = n;

        int[][] combo = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            combo[i][0] = position[i];
            combo[i][1] = speed[i];
        }

        Arrays.sort(combo, (a,b)-> a[0] - b[0]);

        double nextFleetTime = (double)(target - combo[n-1][0])/combo[n - 1][1];

        for(int i = n - 2 ; i >= 0 ; i--){

            double time = (double)(target - combo[i][0])/ combo[i][1];

            if(time <= nextFleetTime){
                carFleets--;
            }
            else{
                nextFleetTime = time;
            }
        }

        return carFleets;
    }
}

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        int l = 0;
        int r = 0;

        for(int i = 0 ; i < n ; i++){
            l = Math.max(l,weights[i]);
            r += weights[i];
        }

        int minCap = r;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(canShip(mid,weights,days)){
                minCap = Math.min(minCap,mid);
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return minCap;


    }

    private boolean canShip(int cap, int[] weights, int availableShips){
        int currCap = cap;
        int ships = 1;
        for(int i = 0; i < weights.length; i++ ){
            if(weights[i] > currCap){
                ships += 1;
                currCap = cap;
            }
            currCap -= weights[i];
        }

        return ships <= availableShips;
    }
}
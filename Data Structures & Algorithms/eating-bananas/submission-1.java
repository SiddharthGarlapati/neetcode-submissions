class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int l = 1;
        int r = piles[0];



        for(int i = 1; i < n ; i++){
            r = Math.max(r,piles[i]);
        }

        int minK = r;

        while(l <= r){
            int k = l + (r - l)/2;

            int time = 0;

            for(int p = 0 ; p < n ; p++){
                time += Math.ceil((double)piles[p]/k);
            }

            if(time <= h){
                minK = Math.min(minK, k);
                r = k - 1;
            }
            else{
                l = k + 1;
            }
        }

        return minK;
        
    }
}

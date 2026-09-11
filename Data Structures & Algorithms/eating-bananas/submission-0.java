class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = piles[0];
        int n = piles.length;

        for(int i = 1 ; i < n; i++ ){
            high = Math.max(high, piles[i]);
        }

        int res = high;

        while(low <= high){
            int k = low + (high - low)/2;
            int hours = 0;

            for(int i = 0; i < n;i++){
                hours += (int)Math.ceil((double)piles[i] / k);
            }

            if( hours <= h){
                res = Math.min(res, k);
                high = k - 1;
            }
            else{
                low = k + 1;
            }

        }

        return res;


        
    }
}

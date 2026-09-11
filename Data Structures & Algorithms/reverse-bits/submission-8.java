class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0 ; i < 32 ; i++){
            int num = n >> i;
            int bit = num & 1;
            res = res | bit << (31 - i);
        }


        return res;
        
    }
}

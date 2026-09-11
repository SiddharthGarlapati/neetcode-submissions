class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;

        for(int num : nums){
            xor = xor ^ num;
        }

        int diff_bit = 1;

        while((xor & diff_bit) == 0){
            diff_bit = diff_bit << 1;
        }

        int a = 0;
        int b = 0;

        for(int num : nums){
            if((num & diff_bit) == 0){
                a = a ^ num;
            }
            else{
                b = b ^ num;
            }
        }

        return new int[]{a,b};






        
    }
}
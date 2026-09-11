class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prev_product = new int[n];
        int[] after_product = new int[n];
        int[] result = new int[n];
        prev_product[0] = 1;
        after_product[n-1] = 1;

        for(int i = 1 ; i < n ; i++){
            prev_product[i] = prev_product[i - 1] * nums[i-1];
        }        

        for(int i = n-2; i >= 0 ; i--){
            after_product[i] = after_product[i + 1] * nums[i+1];
        }

        for(int i = 0 ; i < n ; i++){
            result[i] = prev_product[i] * after_product[i];
        }


        return result;
    }
}  

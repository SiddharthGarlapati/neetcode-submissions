class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProd = nums[0];
        int currMaxProd = nums[0];
        int currMinProd = nums[0];

        for(int i = 1; i < n ; i++){
            
            int temp = currMaxProd;
            currMaxProd = Math.max(Math.max(currMaxProd * nums[i],nums[i]), currMinProd * nums[i]);
            currMinProd = Math.min(Math.min(currMinProd * nums[i], nums[i]), temp * nums[i]);

            maxProd = Math.max(maxProd,currMaxProd);

        }

        return maxProd;
        
    }
}

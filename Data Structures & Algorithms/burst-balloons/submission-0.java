class Solution {
    Integer[][]memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        for(int i = 1 ; i <= n ; i++){
            arr[i] = nums[i - 1];
        }

        memo = new Integer[n+1][n+1];

        return dfs(1,n,arr);

    }

    private int dfs(int left , int right , int[] arr){
        if(left > right){
            return 0;
        }
        if(memo[left][right] != null){
            return memo[left][right];
        }
        
        int coins = 0;
        int res = 0;
        for(int i = left ; i<= right ; i++){
            coins = arr[left - 1 ]* arr[i] * arr[right + 1];
            coins += dfs(left, i - 1,arr) + dfs(i+1,right,arr) ;
            res = Math.max(res, coins);    
        }

        memo[left][right] = res;
        return memo[left][right];
    }
}

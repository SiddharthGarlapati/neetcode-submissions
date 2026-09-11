class Solution {
    int totalSum;
    Integer[][] memo;
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        totalSum = 0;

        for(int num: stones){
            totalSum += num;
        }

        int target = totalSum / 2;
        memo = new Integer[n][totalSum + 1];
        return dfs(0,0,target,stones);
    }

    private int dfs(int i , int sum , int target, int [] stones){
        if(i == stones.length || sum >= target){
            return Math.abs(sum - (totalSum - sum));
        }
        if(memo[i][sum] != null){
            return memo[i][sum]; 
        }
        memo[i][sum] = Math.min(dfs(i + 1, sum , target,stones),
                                dfs(i + 1, sum + stones[i], target,stones));

        return memo[i][sum];                        

    }
}
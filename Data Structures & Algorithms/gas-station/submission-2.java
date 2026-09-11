class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int diffSum = 0;
        int total = 0;
        int start = 0;
        for(int i = 0 ; i < gas.length;i++){

            int diff = gas[i] - cost[i];
            diffSum += diff;
            total += diff;

            if(total < 0){
                total = 0;
                start = i + 1;
            }

        }

        return diffSum < 0 ? -1 : start;
        
    }
}

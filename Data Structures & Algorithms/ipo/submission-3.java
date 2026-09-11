class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {


        int n = profits.length;

        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int i = 0 ; i < n ; i++){
            minCapitalHeap.offer(new int[]{capital[i],profits[i]});
        }

        while(k > 0){

            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w){
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            if(maxProfitHeap.isEmpty()){
                break;
            }

            w += maxProfitHeap.poll();
            k--;
        }

        return w;
        
    }
}
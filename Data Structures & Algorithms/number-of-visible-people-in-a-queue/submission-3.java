class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && heights[i] > heights[st.peek()]){
                res[st.pop()]++;

            }
            if(!st.isEmpty()){
                res[st.peek()]++;
            }

            st.push(i);
        }
        

        return res;
    }
}
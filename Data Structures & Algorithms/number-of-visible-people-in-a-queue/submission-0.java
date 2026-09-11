class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for(int i = n - 1; i >= 0 ; i--){
            while(!st.isEmpty() && heights[i] > st.peek()){
                st.pop();
                res[i]++;
            }

            if(!st.isEmpty()){
                res[i]++;
            }

            st.push(heights[i]);

        }

        return res;
        
    }
}
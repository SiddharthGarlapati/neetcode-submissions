class Solution {
    public int[] findBuildings(int[] heights) {

        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            int curr = heights[i];

            while(!st.isEmpty() && curr >= heights[st.peek()]){
                st.pop();
            }

            st.push(i);
        }

        int[] res = new int[st.size()];

        for(int i = res.length - 1 ; i >= 0; i--){
            res[i] = st.pop();
        }


        return res;


        
    }
}
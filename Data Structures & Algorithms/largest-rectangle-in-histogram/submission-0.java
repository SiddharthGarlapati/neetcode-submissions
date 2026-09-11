class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max_area = 0;

        for(int i = 0 ; i <= n ; i++){
            int currHeight = (i == n ) ? 0: heights[i];

            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int leftSmall = st.isEmpty() ? -1 : st.peek();
                int rightSmall = i;

                int width = rightSmall - leftSmall - 1;

                int area = height * width;
                max_area= Math.max(area,max_area);
            }

            st.push(i);
        }
        
        return max_area;
    }
}

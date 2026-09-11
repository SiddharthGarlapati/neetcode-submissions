class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<int[]> st = new Stack<>();
        int maxArea = 0;

        for(int i = 0 ; i < n ; i++){
            int curr = heights[i];
            int currIndex = i;

            while(!st.isEmpty() && curr < st.peek()[1]){
                int[] temp = st.pop();
                int index = temp[0];
                int val = temp[1];
                int area = (i - index) * val;
                maxArea = Math.max(area,maxArea);
                currIndex = index;

            }

            st.push(new int[]{currIndex, curr});
        }

        while(!st.isEmpty()){
            int[] temp = st.pop();
            int index = temp[0];
            int val = temp[1];
            int area = ( n - index ) * val;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
        
    }
}

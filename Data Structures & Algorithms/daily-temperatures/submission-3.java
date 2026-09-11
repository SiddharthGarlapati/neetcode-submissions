class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            int curr = temperatures[i];

            while(!st.isEmpty() && curr > temperatures[st.peek()]){
                int idx = st.pop();
                res[idx] = i - idx;
            }

            st.push(i);
        }

        return res;
        
    }
}

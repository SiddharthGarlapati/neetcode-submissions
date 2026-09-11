class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            if(tokens[i].equals("+")){
                st.push(st.pop() + st.pop());
            }
            else if (tokens[i].equals("-")){
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            }
            else if(tokens[i].equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if (tokens[i].equals("/")){
                int b = st.pop();
                int a = st.pop();
                st.push(a/b);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }

        }

        return st.pop();
    }
}

class Solution {
    public int calculate(String s) {
        int n = s.length();
        char op = '+';
        int num = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch - '0' >= 0 && ch - '0' <= 9){
                num = num * 10 + (ch - '0');
            }

            if(!(ch - '0' >= 0 && ch - '0' <= 9) && ch != ' ' || (i == n - 1)){
                if(op == '+'){
                    st.push(num);
                }
                else if(op == '-'){
                    st.push(-num);
                }
                else if(op == '*'){
                    st.push(st.pop() * num);
                }
                else if(op == '/'){
                    st.push(st.pop() / num);
                }

                op = ch;
                num = 0;
            }

        }

        int res = 0;

        while(!st.isEmpty()){
            res += st.pop();
        }

        return res;

        
    }
}
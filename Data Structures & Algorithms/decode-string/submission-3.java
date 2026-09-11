class Solution {
    public String decodeString(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(char ch: s.toCharArray()){

            if(ch != ']'){
                st.push(ch);
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(st.peek() != '['){
                    sb.append(st.pop());
                }
                sb.reverse();
                st.pop();

                int base = 1;
                int k = 0 ;

                while(!st.isEmpty() && st.peek() - '0' >= 0 && st.peek() - '0' <= 9){
                    k = (st.pop() - '0') * base + k;
                    base = base * 10;
                }

                for(int i = 0 ; i < k ; i++){
                    for(int j = 0 ; j < sb.length(); j++){
                        st.push(sb.charAt(j));
                    }
                }
                
            }
            
            
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        sb.reverse();

        return sb.toString();
        
    }
}
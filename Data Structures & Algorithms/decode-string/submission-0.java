
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                st.push(ch);
            } else {
                StringBuilder sub = new StringBuilder();

                while (st.peek() != '[') {
                    sub.append(st.pop());
                }

                st.pop(); // remove '['
                sub.reverse();

                int k = 0;
                int base = 1;

                while (!st.isEmpty() && st.peek() >= '0' && st.peek() <= '9') {
                    k = (st.pop() - '0') * base + k;
                    base *= 10;
                }

                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < sub.length(); j++) {
                        st.push(sub.charAt(j));
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}
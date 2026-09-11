class FreqStack {

    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> groups;
    int maxFreq ;

    public FreqStack() {
        freq = new HashMap<>();
        groups = new HashMap<>();
        maxFreq = 0;
        
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0) + 1;
        freq.put(val,f);

        maxFreq = Math.max(f,maxFreq);

        groups.putIfAbsent(f, new Stack<>());
        groups.get(f).push(val);
        
    }
    
    public int pop() {

        Stack<Integer> st = groups.get(maxFreq);

        int res = st.pop();
        freq.put(res, freq.get(res) - 1);

        if(st.isEmpty()){
            maxFreq--;
        }

        return res;
        
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
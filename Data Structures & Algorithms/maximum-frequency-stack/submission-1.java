class FreqStack {
    
    Map<Integer,Integer> counts;
    Map<Integer,Stack<Integer>> groups;
    int maxCount = 0;
    public FreqStack() {
        counts = new HashMap<>();
        groups = new HashMap<>();
    }
    
    public void push(int val) {
        counts.put(val,counts.getOrDefault(val,0) + 1);
        int valCount= counts.get(val);

        if (valCount > maxCount){
            maxCount = valCount;
            groups.put(maxCount, new Stack<>());
        }

        groups.get(valCount).push(val);
        
    }
    
    public int pop() {
        Stack<Integer> st = groups.get(maxCount);
        int res = st.pop();
        counts.put(res, counts.get(res) - 1);
        if(st.isEmpty()){
            groups.remove(maxCount);
            maxCount--;
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
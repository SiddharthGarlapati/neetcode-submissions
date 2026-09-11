class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < m ; i++){
            map.put(nums1[i],i);
        }
        
        Stack<Integer> st = new Stack<>();

        int[] res = new int[m];


        for(int i = 0 ; i < n ; i++){

            if(st.isEmpty() && map.containsKey(nums2[i])){
                st.push(nums2[i]);
            }

            if(!st.isEmpty()){
                while(!st.isEmpty() && nums2[i] > st.peek()){
                    int num = st.pop();
                    int idx = map.get(num);
                    res[idx] = nums2[i];
                }
                if(map.containsKey(nums2[i])){
                    st.push(nums2[i]);
                }
            }
        }

        while(!st.isEmpty()){
            int num = st.pop();
            int idx = map.get(num);
            res[idx] = -1;
        }

        return res;
    }
}
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

        Arrays.fill(res, -1);


        for(int i = 0 ; i < n ; i++){

            int curr = nums2[i];

            while(!st.isEmpty() && curr > st.peek()){
                    int num = st.pop();
                    int idx = map.get(num);
                    res[idx] = curr;
            }

            if(map.containsKey(nums2[i])){
                st.push(nums2[i]);
            }

            
        }

        return res;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int i = 0 ; i <= nums.length; i++){
            bucket[i] = new ArrayList<>();
        }

        for(int num : map.keySet()){
            bucket[map.get(num)].add(num);
        }

        int[] res = new int[k];
        int idx = 0;

        for(int i = nums.length ; i >= 0 ; i--){
            for(int num : bucket[i]){
                res[idx] = num;
                if(idx + 1 == k){
                    return res;
                }
                idx++;
            }
        }
        
        return res;
    }
}

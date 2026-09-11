class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map  = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();


        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(int i = 0 ; i <= nums.length; i++){
            list.add(new ArrayList<>());
        }

        for(int key: map.keySet()){
            int value = map.get(key);
            list.get(value).add(key);
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = list.size() - 1; i >= 0 && index < k; i--){
            for( int num: list.get(i)){
                result[index++] = num;
                if(index == k) break;
            }
        }

        return result;
        
    }
}

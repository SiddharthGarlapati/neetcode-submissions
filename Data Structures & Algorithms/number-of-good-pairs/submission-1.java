class Solution {
    public int numIdenticalPairs(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        int pairs = 0;

        for(int num: map.keySet()){
            int count = map.get(num);
            if(count > 1 ){
                pairs += (count * (count - 1))/ 2;
            }
        }

        return pairs;
        
    }
}
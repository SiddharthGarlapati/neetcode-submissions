class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(hand);

        for(int card : hand){
            map.put(card, map.getOrDefault(card,0) + 1);
        }

        for(int card : hand){
            if(map.get(card) == 0){
                continue;
            }

            for(int i = card ; i < card + groupSize ; i++){
                if(!map.containsKey(i) || map.get(i) == 0){
                    return false;
                }
                map.put(i,map.get(i) - 1);
            }
        }

        return true;
    }
}

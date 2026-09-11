class Solution {
    public List<Integer> partitionLabels(String s) {

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        int size = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            size++;
            end = Math.max(end, map.get(ch));
            if(i == end){
                res.add(size);
                size = 0;
            }
        }

        return res;
        
    }
}

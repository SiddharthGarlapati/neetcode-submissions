class Solution {
    public List<Integer> partitionLabels(String s) {

        int n = s.length();
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < n; i++){
            map.put(s.charAt(i),i);
        }

        int size = 0;
        int end = 0;

        for(int i = 0 ; i < n; i++){
            size++;
            end = Math.max(end,map.get(s.charAt(i)));
            
            if(i == end){
                res.add(size);
                size = 0;
            }
        }
        
        return res;
    }
}

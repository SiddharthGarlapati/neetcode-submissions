class Pair{
    String str;
    int val;
    
    public Pair(String str , int val){
        this.str = str;
        this.val = val;
    }
}

class TimeMap {
    
    Map<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();


        
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k -> new ArrayList<>()).add(new Pair(value,timestamp));





        
    }
    
    public String get(String key, int timestamp) {

        String res = "";

        if(!map.containsKey(key)){
            return res;
        }

        List<Pair> values = map.get(key);

        int left = 0;
        int right = values.size() - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            Pair p = values.get(mid);
            if(p.val <= timestamp){
                res = p.str;
                left = mid + 1;
            }
            else{
                right = mid - 1;
                
            }
        }

        return res;
        

        





    }
}

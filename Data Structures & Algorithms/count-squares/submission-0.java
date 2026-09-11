class CountSquares {
    
    Map<String,Integer> count;
    List<int[]> ls;
    public CountSquares() {
        count = new HashMap<>();
        ls = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        count.put(key, count.getOrDefault(key,0) + 1);
        ls.add(point);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;

        for(int[] xy : ls){
            int x = xy[0];
            int y = xy[1];
            if(Math.abs(px - x) != Math.abs(py - y) ||
             (px == x && py == y)) continue;

            String p1 =  x + "," + py;
            String p2 = px + "," + y;

            if(count.containsKey(p1) && count.containsKey(p2)){
                res += count.get(p1) * count.get(p2);
            } 
        }

        return res;
        
    }
}

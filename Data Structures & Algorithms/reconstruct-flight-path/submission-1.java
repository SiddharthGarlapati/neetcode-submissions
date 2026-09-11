class Solution {

    Map<String,List<String>> graph;
    List<String> res;
    int ticketCount = 0;
    public List<String> findItinerary(List<List<String>> tickets) {

        graph = new HashMap<>();
        ticketCount = tickets.size(); 

        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));

        for(List<String> ticket : tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            graph.putIfAbsent(source, new ArrayList<>());
            graph.get(source).add(destination);
        }

        res = new ArrayList<>();
        res.add("JFK");

        if(!dfs("JFK")){
            return new ArrayList<>();
        }

        return res;
        
    }

    private boolean dfs(String src){

        if(res.size() == ticketCount + 1) return true;

        if(!graph.containsKey(src)) return false;

        List<String> destinations = graph.get(src);

        for(int i = 0 ; i < destinations.size(); i++){
            String next = destinations.get(i);

            res.add(next);
            destinations.remove(i);
            if(dfs(next)) return true;

            res.remove(res.size() - 1);
            destinations.add(i,next);

        }

        return false;
    }
}

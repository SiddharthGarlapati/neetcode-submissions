/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        q.offer(node);
        while(!q.isEmpty()){
            Node original = q.poll();
            for(Node nei : original.neighbors){
                if(!map.containsKey(nei)){
                    map.put(nei,new Node(nei.val));
                    q.offer(nei);
                }
                map.get(original).neighbors.add(map.get(nei));
            }
        }
        
        return copy;
    }
}
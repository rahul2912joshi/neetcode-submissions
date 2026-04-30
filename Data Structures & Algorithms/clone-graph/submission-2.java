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
        if(node==null) return null;
        Node newNode = new Node(node.val);
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,newNode);
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neigh : curr.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh, new Node(neigh.val));
                    q.offer(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh)); 
            }
        }
        return newNode;
    }
}
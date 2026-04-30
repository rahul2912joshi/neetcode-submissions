/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hm = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            Node clone = new Node(curr.val);
            hm.put(curr,clone);
            curr = curr.next;
        }
        for(Map.Entry<Node,Node> entry : hm.entrySet()){
            entry.getValue().next = hm.get(entry.getKey().next);
            entry.getValue().random = hm.get(entry.getKey().random);
        }
        return hm.get(head);
    }
}
// 2 -> 3 -> 4 -> 5 -> 6

/*
2  -  2
3  -  3
4  - 4
5 - 5
6 - 6
*/

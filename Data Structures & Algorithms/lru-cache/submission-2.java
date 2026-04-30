class LRUCache {

    class Node{
        int key, value;
        Node prev,next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    HashMap<Integer,Node> keys = new HashMap<>();
    Node head,tail;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev= head;
    }
    
    public int get(int key) {
        if(keys.containsKey(key)) {
            Node node = keys.get(key);
            remove(node);
            addToHead(node); //TODO
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keys.containsKey(key)){
            Node node = keys.get(key);
            node.value = value;
            remove(node);
            addToHead(node); //TODO
        } else{
            if(keys.size()==capacity){
                Node lru = tail.prev;
                remove(lru); //TODO
                keys.remove(lru.key);
            }
            Node node = new Node(key,value);
            addToHead(node);
            keys.put(key,node);
        }
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}
// 1 2 3 4
// get(key) -> HashMap to do O(1) gets. - map<key,value> - put this node at front
// put(key) -> if present - update value
                // else add to map and add to list front - if(list>size) remove from last
                // remove should happen in both map and list.

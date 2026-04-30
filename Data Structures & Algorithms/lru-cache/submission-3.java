class LRUCache {

    class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }
    HashMap<Integer,Node> keys = new HashMap<>();
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(keys.containsKey(key)){
            Node node = keys.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keys.containsKey(key)){
            Node node = keys.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else{
            if(keys.size()==capacity){
                Node lru = tail.prev;
                remove(lru);
                keys.remove(lru.key);
            }
            Node node = new Node(key,value);
            addToHead(node);
            keys.put(key,node);
        }
    }

    public void remove(Node node){
        Node leftNode = node.prev;
        Node rightNode = node.next;
        leftNode.next = rightNode;
        rightNode.prev = leftNode;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}

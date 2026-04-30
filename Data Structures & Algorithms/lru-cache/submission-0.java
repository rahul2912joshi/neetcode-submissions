class LRUCache {

    HashMap<Integer,Integer> keys = new HashMap<>();
    LinkedList<Integer> lru = new LinkedList<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(keys.containsKey(key)) {
            lru.remove((Integer)key);
            lru.addFirst(key);
            return keys.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keys.containsKey(key)){
            lru.remove((Integer)key);
            lru.addFirst(key);
        } else{
            if(lru.size()<capacity || lru.size()==0){
                lru.addFirst(key);
            } else{
                int temp = lru.removeLast();
                lru.addFirst(key);
                keys.remove(temp);
            }
        }
        keys.put(key,value);
    }
}
// get(key) -> HashMap to do O(1) gets. - map<key,value> - put this node at front
// put(key) -> if present - update value
                // else add to map and add to list front - if(list>size) remove from last
                // remove should happen in both map and list.

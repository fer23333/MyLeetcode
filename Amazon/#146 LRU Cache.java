
import java.util.LinkedHashMap;

class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
          //0.75 负载因子 load factor 
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


使用自定的doublylinkedlist 和 hashmap
如果使用实际的 deque 时间复杂度会变高 
access a random key O(1) - hashmap
remove last entry in lru cache O(1) - list
add or remove an entry in front of the lru cache O(1) -doubly linkedlist


class LRUCache {
    
    class Node{
        int key, value;
        Node next, prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<Integer, Node> map;
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int cap;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        //remove and move to tail then return value
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        addToTail(cur);
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1){
            map.get(key).value = value;        
        }else{
            //larger thean cap, remove least used element
            if(map.size() == cap){
                //revmoe head.next
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
            }
            Node insert = new Node(key,value);
            addToTail(insert);
            map.put(key, insert);
        }
        
    }
    
    public void addToTail(Node node){
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;  
        node.next = tail;       
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


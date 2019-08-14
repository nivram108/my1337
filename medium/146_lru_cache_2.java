//TAG ArrayList,Queue,HashMap,Map
class LRUCache {

    int capacity;
    int nodeSize;
    ListNode head;
    ListNode tail;
    int consoleCount;
    HashMap<Integer, Integer> keyValueMap;//store value of the key
    HashMap<Integer, ListNode> keyNodeMap;//store index of keys in lruList
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyValueMap = new HashMap<>();
        keyNodeMap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        nodeSize = 0;
        consoleCount = 0;
    }

    public int get(int key) {
        consoleCount = 0;
        if (keyValueMap.containsKey(key)) {
            update(key);
            return keyValueMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        consoleCount = 0;
        keyValueMap.put(key, value);
        update(key);
    }

    void update(int key) {
        //if key exist
        if(keyNodeMap.containsKey(key)) {
            removeKey(key);
        }

        addNode(key);
        if(nodeSize > capacity) {
            int lruKey = head.next.key;
            removeKey(lruKey);
            keyValueMap.remove(lruKey);

        }

    }

    void removeKey(int key) {
        ListNode node = keyNodeMap.get(key);
        keyNodeMap.remove(key);
        nodeSize --;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addNode(int key) {
        //append node to tail
        ListNode node = new ListNode();
        node.key = key;
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        nodeSize ++;
        keyNodeMap.put(key, node);

    }
}

class ListNode {
    int key;
    ListNode next;
    ListNode prev;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

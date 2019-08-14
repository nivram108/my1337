//TAG ArrayList,Queue,HashMap,Map
class LRUCache {

    int mCapacity;
    ArrayList<Integer> lruList;//store lru keys in order
    HashMap<Integer, Integer> keyValueMap;//store value of the key
    HashMap<Integer, Integer> keyLruIndexMap;//store index of keys in lruList
    public LRUCache(int capacity) {
        mCapacity = capacity;
        lruList = new ArrayList<>();
        keyValueMap = new HashMap<>();
        keyLruIndexMap = new HashMap<>();
    }

    public int get(int key) {
        if(keyValueMap.containsKey(key)){
            int value = keyValueMap.get(key);
            update(key);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        keyValueMap.put(key,value);
        update(key);
    }
    void update(int key) {
        // remove key in lruList if key exists
        if(keyLruIndexMap.containsKey(key)) {
            lruList.remove(new Integer(key));
        }
        // add key to index map and lruList
        keyLruIndexMap.put(key, lruList.size());
        lruList.add(key);

        //remove lru element if over capicity
        if(lruList.size() > mCapacity) {
            int lruKey = lruList.get(0);
            lruList.remove(0);
            if(key == lruKey) return;
            keyValueMap.remove(lruKey);
            keyLruIndexMap.remove(lruKey);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

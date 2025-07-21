class LRUCache {
    private final LinkedHashMap<Integer,Integer> lhm;
    int capacity = 0;
    public LRUCache(int capacity) {
        this.lhm = new LinkedHashMap<>(capacity, 1f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return lhm.getOrDefault(key, -1); 
        
    }
    
    public void put(int key, int value) {
        if (lhm.containsKey(key)) {
            lhm.put(key, value);
            return;
        }
        
        if (lhm.size() >= capacity) {
            int lruKey = lhm.entrySet().iterator().next().getKey();
            lhm.remove(lruKey);
        }

        lhm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
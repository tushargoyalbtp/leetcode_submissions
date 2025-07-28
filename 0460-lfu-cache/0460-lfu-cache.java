class LFUCache {
    class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    int cap, minFreq;
    Map<Integer, Node> nodeMap; // key → Node
    Map<Integer, LinkedHashSet<Integer>> freqMap; // freq → keys

    public LFUCache(int capacity) {
        this.cap = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cap == 0) return;

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (nodeMap.size() == cap) {
                int evictKey = freqMap.get(minFreq).iterator().next(); // LRU among min freq
                freqMap.get(minFreq).remove(evictKey);
                nodeMap.remove(evictKey);
            }

            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node.key);

        if (freqMap.get(oldFreq).isEmpty()) {
            freqMap.remove(oldFreq);
            if (oldFreq == minFreq) minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new LinkedHashSet<>()).add(node.key);
    }
}
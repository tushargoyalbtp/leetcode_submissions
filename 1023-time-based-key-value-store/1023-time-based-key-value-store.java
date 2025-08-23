class TimeMap {
    
    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, value);
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        } else {
            String ans = "";
            List<Pair> list1 = map.get(key);
            int start = 0;
            int end = list1.size() - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                Pair pair = list1.get(mid);

                if (pair.timestamp == timestamp) {
                    return pair.value;
                } else if (pair.timestamp < timestamp) {
                    ans = pair.value; // keep track of last valid
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return ans;
        }
    }

    class Pair {
        int timestamp;
        String value;
        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
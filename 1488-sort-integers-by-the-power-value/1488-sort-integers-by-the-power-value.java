class Solution {
    public int getKth(int lo, int hi, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for( int i = lo; i <= hi; i++ ){
            int getIndexLo = functionCount(i, 0);
            map.put(i, getIndexLo);
        }

        int ans = 0;


        for(Map.Entry<Integer,Integer> element : map.entrySet()){

            int key = element.getKey();
            int value = element.getValue();
            System.out.println(key + " ---> " + value);

        }

        // ✅ Sort entries by value and key, then iterate to get k-th element
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());

        Collections.sort(sortedList, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue(); // sort by power value
            } else {
                return a.getKey() - b.getKey();     // break tie by number
            }
        });

        for (Map.Entry<Integer, Integer> element : sortedList) {
            if (k == 1) {
                ans = element.getKey(); // ✅ Return the number (not power value)
                break;
            }
            k--;
        }

        return ans;
    }   
    
    public int functionCount(int lo, int count){
        if(lo == 1){
            return count;
        }
        if(lo % 2 == 0){
            count++;
            return functionCount(lo/2, count);
        }

        else {
            count++;
            return functionCount(3*lo+1, count);
        }
    }
}
class Solution {
    
    HashMap<Integer,Integer> dpmap = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for( int i = lo; i <= hi; i++ ){
            int getIndexLo = functionCount(i);
            map.put(i, getIndexLo);
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());

        // Sort by power value, then by number
        Collections.sort(sortedList, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            } else {
                return a.getKey() - b.getKey();
            }
        });

        return sortedList.get(k - 1).getKey();
    }   
    
    public int functionCount(int lo){
        if(lo == 1){
            return 0;
        }

        if(dpmap.containsKey(lo)){
            return dpmap.get(lo);
        }

        int result = 0;

        if(lo % 2 == 0){

            result = 1 + functionCount(lo/2);
        }

        else {

            result = 1 + functionCount(3*lo+1);
        }

        dpmap.put(lo, result);
        return result;
    }
}
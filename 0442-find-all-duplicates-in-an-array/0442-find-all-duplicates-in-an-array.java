class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer,Integer> element : map.entrySet()){
            int key = element.getKey();
            int value = element.getValue();

            if(value>=2){
                arrayList.add(key);
            }
        }

        return arrayList;
    }
}
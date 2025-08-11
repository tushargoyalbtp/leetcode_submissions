class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringMap = new HashMap<>();
        
        for (String str : strs) {
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            String textkey = String.valueOf(chArray);
            
            if (!stringMap.containsKey(textkey)) {
                stringMap.put(textkey, new ArrayList<>());
            }
            stringMap.get(textkey).add(str);
        }

        return new ArrayList<>(stringMap.values());
    }
}
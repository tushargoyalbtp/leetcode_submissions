class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> ansList = new HashMap<String, List<String>>();

        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);

            String text = String.valueOf(chars);

            if(!ansList.containsKey(text)){
                ansList.put(text, new ArrayList<>());
            }

            ansList.get(text).add(strs[i]);
        }

        return new ArrayList<>(ansList.values());


    }
}




// eat -> {eta, tae, ate, aet, tea, eta}
// ["eat","tea","tan","ate","nat","bat"]


// aet 


// {at}
// a -> 6
// b -> 1
// e -> 3
// n -> 2
// t -> 6

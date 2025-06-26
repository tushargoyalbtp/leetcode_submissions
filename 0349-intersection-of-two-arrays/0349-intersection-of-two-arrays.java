class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            int x = nums2[i];
            if(map.containsKey(x)){
                list.add(x);
                map.remove(x);
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;

    }
}
class Solution {
    public int majorityElement(int[] nums) {
        
        int ans = 0;
        int freq = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) > freq) {
                ans = nums[i];
                break;
            }
        }

        return ans;
    }
}
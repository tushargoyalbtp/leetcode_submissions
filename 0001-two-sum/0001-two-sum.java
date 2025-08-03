class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                ans[0] = map.get(rem);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
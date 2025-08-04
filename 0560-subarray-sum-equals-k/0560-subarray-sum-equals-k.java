class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: sum = 0 occurs once

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // Check if there's a prefix sum that satisfies: sum - k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // Update the current sum in map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort to handle duplicates
        List<List<Integer>> subsetLists = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), subsetLists);
        return subsetLists;
    }

    private void backtrack(int start, int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));  // Always add a copy of the current list

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempList.add(nums[i]);
            backtrack(i + 1, nums, tempList, result);
            tempList.remove(tempList.size() - 1);  // Backtrack
        }
    }
}

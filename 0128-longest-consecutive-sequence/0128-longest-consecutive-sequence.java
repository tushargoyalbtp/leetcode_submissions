class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int countAns = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) { // start of sequence
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                countAns = Math.max(countAns, count);
            }
        }
        return countAns;
    }
}

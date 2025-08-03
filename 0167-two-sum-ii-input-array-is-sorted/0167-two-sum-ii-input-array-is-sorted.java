class Solution {

    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];

        int i = 0;
        int j = numbers.length - 1;
        while (i <= j) {
            int sum = numbers[i] + numbers[j];

            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ans[0] = i + 1; // Convert to 1-based index
                ans[1] = j + 1;
                break;
            }
        }

        return ans;
    }
}
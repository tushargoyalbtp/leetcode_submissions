class Solution {

    private int[] prefixSums;
    private int totalSum;
    private Random rand;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        totalSum = 0;
        rand = new Random();

        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i] = totalSum;
        }

    }

    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1; // random number from 1 to totalSum
        int low = 0, high = prefixSums.length - 1;

        // Binary search for the smallest index such that prefixSums[i] >= target
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
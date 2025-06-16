class Solution {
    public int totaltimerequire(int[] arr, int mid, int k) {
        int totaltime = 0;

        for (int i = 0; i < arr.length; i++) {
            totaltime += Math.ceil((double) arr[i] / (double) mid);
        }

        return totaltime;
    }

    public int minEatingSpeed(int[] arr, int k) {

        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            high = Math.max(high, arr[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            int totalHours = totaltimerequire(arr, mid, k);

            if (totaltimerequire(arr, mid, k) <= k) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }
}
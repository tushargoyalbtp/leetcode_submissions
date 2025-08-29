class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
           List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals that come before newInterval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // merged newInterval

        // 3. Add all remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // 4. Convert result list to array
        return result.toArray(new int[result.size()][]);
    }
}


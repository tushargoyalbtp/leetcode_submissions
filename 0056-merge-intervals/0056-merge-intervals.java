import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.length;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // Keep merging overlapping intervals
            while (i + 1 < n && intervals[i + 1][0] <= end) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }

            // Add merged interval
            List<Integer> merged = new ArrayList<>();
            merged.add(start);
            merged.add(end);
            result.add(merged);

            i++;
        }

        // Convert result to int[][]
        int[][] ans = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            ans[j][0] = result.get(j).get(0);
            ans[j][1] = result.get(j).get(1);
        }

        return ans;
    }
}


// import java.util.*;

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         if (intervals.length <= 1) return intervals;

//         // Sort by start time
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         List<int[]> result = new ArrayList<>();
//         int[] current = intervals[0];

//         for (int i = 1; i < intervals.length; i++) {
//             int[] next = intervals[i];

//             if (current[1] >= next[0]) {
//                 current[1] = Math.max(current[1], next[1]); // merge
//             } else {
//                 result.add(current);
//                 current = next;
//             }
//         }

//         result.add(current);

//         return result.toArray(new int[result.size()][]);
//     }
// }

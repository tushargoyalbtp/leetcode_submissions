// class Solution {
//     public int[][] merge(int[][] intervals) {

//         List<List<Integer>> result = new ArrayList<>();

//         int n = intervals.length;

//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

//         for (int i = 0; i < n;) {

//             List<Integer> list = new ArrayList<>();

//             if (i+1 >= n-1 && intervals[i][1] >= intervals[i+1][0] && intervals[i][1] <= intervals[i + 1][1]) {
//                 list.add(intervals[i][0]);
//                 list.add(intervals[i + 1][1]);
//                 i+=2;
//             }
//             else{
//                 list.add(intervals[i][0]);
//                 list.add(intervals[i][1]);
//                 i++;
//             }

//             result.add(list);
//         }

//         int[][] ans = new int[result.size()][2];
//         int i = 0;

//         for (List<Integer> element : result) {
//             ans[i][0] = element.get(0); // â Assign to the correct row and column
//             ans[i][1] = element.get(1);
//             i++;
//         }

//         return ans;

//     }
// }



import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]); // merge
            } else {
                result.add(current);
                current = next;
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}

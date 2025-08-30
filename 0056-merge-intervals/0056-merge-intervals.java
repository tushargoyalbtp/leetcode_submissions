class Solution {

    public int[][] merge(int[][] intervals) {
        
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> anslist = new ArrayList<>();
        
        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // Merge all overlapping intervals
            while (i + 1 < intervals.length && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            
            anslist.add(new int[]{start, end});
            i++;
        }
        
        // Convert result list to array
        return anslist.toArray(new int[anslist.size()][]);
    }
}
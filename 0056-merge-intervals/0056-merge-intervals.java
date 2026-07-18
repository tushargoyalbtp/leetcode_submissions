import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Fix 1: Edge case guard (prevent IndexOutOfBoundsException on empty inputs)
        if (intervals.length == 0) return new int[0][0];
        
        List<List<Integer>> ansList = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int x = intervals[0][0];
        int y = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int currentX = intervals[i][0];
            int currentY = intervals[i][1];

            // Fix 2: If there's NO overlap (currentX > y), save the previous interval and start a new one
            if(currentX > y){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                ansList.add(list);
                
                x = currentX; // Reset to the new starting boundary
                y = currentY;
            } else {
                // If there IS an overlap, update the upper bound to the maximum ending time
                y = Math.max(y, currentY);
            }
        }
        
        // Fix 3: Add the very last processed interval to the list
        List<Integer> lastList = new ArrayList<>();
        lastList.add(x);
        lastList.add(y);
        ansList.add(lastList);

        // Fix 4: Corrected the final 2D array conversion syntax
        int[][] res = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            res[i][0] = ansList.get(i).get(0);
            res[i][1] = ansList.get(i).get(1);
        }
        return res;
    }
}

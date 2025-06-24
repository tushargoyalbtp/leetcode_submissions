

class Solution {

    public int getNextIndex(int[][] intervals, int startIndex, int currJobEnd, int n){
        int endindex =  n-1;
        int result = n + 1;
        while(startIndex <= endindex){
            
            int mid = (startIndex) + (endindex-startIndex)/2;

            if(intervals[mid][0] >= currJobEnd){
                result = mid;
                endindex = mid - 1;

            }
            else{
                startIndex = mid+1;
            }
        }

        return result;
    }

    public int functionSolver(int[][] intervals, int index, int n, int[] memomization){
        if(index >= n){
            return 0;
        }

        if(memomization[index] !=  -1){
            return memomization[index];
        }
        int nextIndex = getNextIndex(intervals, index+1, intervals[index][1], n);
        // functionsolve is a bianrysearch approach
        int taken = intervals[index][2] + functionSolver(intervals, nextIndex, n, memomization);
        int nottaken = functionSolver(intervals, index+1, n, memomization);

        return memomization[index] = Math.max(taken, nottaken);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] intervals = new int[n][3];
        int[] memomization = new int[50001];

        Arrays.fill(memomization, -1);

        for(int i = 0; i < n; i++){
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }

        //Sorting based upon the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        return functionSolver(intervals, 0, n, memomization);
    }

}
class Solution {
    public int countDays(int days, int[][] meetings) {
        // HashSet<Integer> setDays = new HashSet<>();

        // for(int i = 1 ; i <= days; i++){
        //     setDays.add(i);
        // }

        // for(int[] meeting : meetings){
        //     int startday = meeting[0];
        //     int endday = meeting[1];

        //     while(startday <= endday){
        //         if(setDays.contains(startday)){
        //             setDays.remove(startday);
        //         }
        //         startday++;
        //     }
        // }

        // return setDays.size();
        
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // for(int [] meeting : meetings){
        //     System.out.println(meeting[0] + " " + meeting[1]);
        // }

        int prevEnd = 0;
        for(int[] meeting : meetings){
            // System.out.println("prevend : " + prevEnd);
            int start = Math.max(meeting[0], prevEnd + 1);
            // System.out.println("start days " + start);
            int length = meeting[1] - start + 1;
            // System.out.println("length of start and end days " + length);
            days -= Math.max(length, 0);
            prevEnd = Math.max(prevEnd, meeting[1]);
        }

        return days;
    }
} 
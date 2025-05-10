class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int oldsize = intervals.length;

        List<List<Integer>> mergedList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(newInterval[0]);
        temp.add(newInterval[1]);
        mergedList.add(temp);


        for(int[] element : intervals){
            List<Integer> listMerged = new ArrayList<>();

            listMerged.add(element[0]);
            listMerged.add(element[1]);

            mergedList.add(listMerged);

        }

        int[][] finalArray = new int[mergedList.size()][2];

        int i = 0;
        for(List<Integer> element : mergedList){
            finalArray[i][0] = element.get(0);
            finalArray[i][1] = element.get(1);
            System.out.println(finalArray[i][0]+ " " + finalArray[i][1]);
            i++;
        }

        Arrays.sort(finalArray, (a,b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> ansList = new ArrayList<>();

        int k = 0;
        while(k < finalArray.length){
            int start = finalArray[k][0];
            int end = finalArray[k][1];

            while(k+1<finalArray.length && finalArray[k+1][0] <= end){
                end = Math.max(end, finalArray[k+1][1]);
                k++;
            }

            List<Integer> merged = new ArrayList<>();
            merged.add(start);
            merged.add(end);
            ansList.add(merged);

            k++;
        }

        int[][] ans = new int[ansList.size()][2];
        for (int j = 0; j < ansList.size(); j++) {
            ans[j][0] = ansList.get(j).get(0);
            ans[j][1] = ansList.get(j).get(1);
        }

        return ans;
    }
}
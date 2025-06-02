class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer> lastRain = new HashMap<>();

        int n = rains.length;

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < rains.length; i++){
            int rainDrop = rains[i];
            if(rainDrop == 0){
                set.add(i);
                ans[i] = 1;
            }

            else{
                Integer id = lastRain.get(rainDrop);

                if(id == null){
                    lastRain.put(rains[i], i);
                }
                else{
                    Integer dryingDay = set.higher(id);

                    if(dryingDay == null){
                        return new int[0];
                    }
                    ans[dryingDay] = rainDrop;
                    set.remove(dryingDay);
                    lastRain.put(rainDrop, i);
                }
                ans[i] = -1;
            }
        }

        return ans;
    }
}

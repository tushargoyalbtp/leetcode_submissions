class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int totalfuel = 0;
        int totalcost = 0;
        int n = cost.length;
        int tank = 0;

        for (int i = 0; i < n; i++) {
            totalfuel += gas[i];
            totalcost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0 ){
                index = i + 1;
                tank = 0;
            }
        }

        return totalfuel >= totalcost ? index : -1;
    }
}
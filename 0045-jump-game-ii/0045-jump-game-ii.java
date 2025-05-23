class Solution {
    public int jump(int[] nums) {
        int near = 0 ;
        int far = 0;
        int jumps = 0;
        int lastIndex = nums.length - 1;
        while(far < lastIndex){
            int furthest  = 0;
            for(int i = near; i  <= far ; i++){
                furthest = Math.max(furthest, i + nums[i]);
            }

            near = far + 1;
            far = furthest;
            jumps++;
        }

        return jumps;
    }
}
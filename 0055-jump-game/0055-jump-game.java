class Solution {
    public boolean canJump(int[] nums) {

        // for(int i=0; i<nums.length;){
        //     if(nums[i] == 0 && i<nums.length-1){
        //         return false;
        //     }

        //     else if(nums[i] == 0 && i==nums.length-1){
        //         return true;
        //     }
        //     else if(i==nums.length-1){
        //         return true;
        //     }
        //     i = i+nums[i];

        // }

        // return false;

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}
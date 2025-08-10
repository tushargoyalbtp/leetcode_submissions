class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxAns = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 1){
                count = 0;
            }
            else{
                count++;
            }
            maxAns = Math.max(maxAns, count);
        }

        return maxAns;
    }
}
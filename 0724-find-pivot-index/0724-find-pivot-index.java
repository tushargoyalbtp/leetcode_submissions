class Solution {
    public int pivotIndex(int[] nums) {
        int ans = 0;
        // 0 -> i-1
        // i+1 -> n

       

        for(int i = 0; i < nums.length; i++){

            int prefixSum = 0;

            if(i>0){
                prefixSum = sumAll(0, i-1, nums);
            } 

            int suffixSum = 0;

            if(i+1 < nums.length){
                suffixSum = sumAll(i+1, nums.length-1, nums);
            }
            if(prefixSum == suffixSum){
                return i;
            }
        }

        return -1;
    }

    public int sumAll(int start, int end, int[] nums){
        int sum = 0;

        for(int i = start ; i <= end; i++){
            sum += nums[i];
        }

        return sum;
    }
}
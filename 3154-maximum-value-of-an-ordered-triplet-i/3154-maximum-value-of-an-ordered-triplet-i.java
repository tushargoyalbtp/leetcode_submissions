class Solution {
    public long maximumTripletValue(int[] nums) {
        
        long ans = Integer.MIN_VALUE;

        for(int i=0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k = j+1; k<nums.length; k++){
                    if(nums[i] < 0 && nums[j] < 0 && nums[k] < 0){
                        ans = Math.max(ans, 0);
                    }
                    else{
                        long temp = nums[i] - nums[j];
                        long result = (temp * nums[k]);
                        // System.out.println("result of an array: " +  result);
                        if(result < 0 ){
                            ans = Math.max(ans, 0);
                        }
                        else{
                            ans = Math.max(ans, result);
                        }
                    }
                }
            }
        }

        return ans;
    }
}
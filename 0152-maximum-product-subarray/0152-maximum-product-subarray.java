class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;

        int forwprod = nums[0];
        int forwans = nums[0];

        for(int i = 1; i < n; i++){
            if( forwprod  == 0){
                forwprod = nums[i];
            }
            else{
                forwprod *= nums[i];
            }

            forwans = Math.max(forwans, forwprod);
        }
        
        int backprod = nums[n-1];
        int backans = nums[n-1];

        for(int i = n-2; i >= 0; i--){
            if(backprod == 0){
                backprod = nums[i];
            }
            else{
                backprod *= nums[i];
            }
            backans = Math.max(backans, backprod);
        }

        return Math.max(forwans, backans);
        
    }
}
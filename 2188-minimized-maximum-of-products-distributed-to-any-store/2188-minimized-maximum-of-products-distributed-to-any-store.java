class Solution {

    public boolean isDistributionPossible(int[] quantity, int mid, int n){
        int shopCount = 0;

        for(int i = 0; i < quantity.length; i++){
            shopCount += quantity[i]/mid;
            if(quantity[i]%mid!=0){
                shopCount+=1;
            }
            if(shopCount>n){
                return false;
            }
        }

        return true;

    }
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int qua : quantities){
            high = Math.max(qua, high);
        }

        int res = -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(isDistributionPossible(quantities, mid, n)){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return res;
    }
}
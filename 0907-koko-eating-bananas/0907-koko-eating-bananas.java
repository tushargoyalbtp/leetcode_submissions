class Solution {
    public int totaltimerequired(int[] arr, int mid){
        
        int totaltime = 0;
        
        for(int i = 0; i < arr.length; i++){
            totaltime += Math.ceil((double) arr[i] / (double) mid);
        }

        return totaltime;
    }
    
    public int minEatingSpeed(int[] arr, int k) {
        int l = 1;
        int h = Integer.MIN_VALUE;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            h = Math.max(h, arr[i]);
        }

        while(l <= h){
            int mid = (l+h)/2;

            if(totaltimerequired(arr,mid) <= k){
                h = mid - 1;
                ans = mid;
            }
            else{
                l = mid + 1;
            }
        }

        return ans;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int h = 0;

        for(int i = 0; i < weights.length; i++){
            l = Math.max(l, weights[i]);
            h += weights[i];
        }

        while(l < h){
            int mid = l + (h-l)/2;

            if(canship(weights, days, mid)){
                h = mid;
            }
            else{
                l = mid+1;
            }

        }

        return l;
    }

    public boolean canship(int[] weights, int days, int capacity){
        int currentw = 0;
        int needdays = 1;

        for(int i = 0 ; i < weights.length; i++){
            if(currentw + weights[i] > capacity){
                needdays++;
                currentw = 0;
            }
            currentw += weights[i];
        }

        return needdays <= days;
    }
}
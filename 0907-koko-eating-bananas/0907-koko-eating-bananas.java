class Solution {

    public int findTotalHours(int[] piles, int speed){
        int ans = 0;
        for(int pile : piles){
            ans += Math.ceil((double)pile / (double)speed);
        }

        return ans;
    }


    public int findMaxPiles(int[] piles){
        int maxPiles = 0;

        for(int pile : piles){
            maxPiles = Math.max(maxPiles, pile);
        }

        return maxPiles;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;

        int r = findMaxPiles(piles);

        while(l<=r){
            int mid = (l+r)/2;

            int totalHours = findTotalHours(piles, mid);

            if(totalHours <= h){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return l;
    }
}
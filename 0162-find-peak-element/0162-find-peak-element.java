class Solution {
    // public boolean comparemid(int start, int end, int target, int[] nums){
    //     for(int i = start; i <= end; i++){
    //         if(nums[i] >= target){
    //             return false;
    //         }
    //     }

    //     return true;
    // }
    public int findPeakElement(int[] nums) {
         int l = 0, r = nums.length - 1;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                // peak lies on the left (including mid)
                r = mid;
            } else {
                // peak lies on the right
                l = mid + 1;
            }
        }
        
        return l; // or r (both converge to a peak)
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int a=-1,b=-1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
            a=mid;
            right=mid-1;
            }
            else if(nums[mid]<target)
            left=mid+1;
            else
            right=mid-1;
        }  
        left=0;right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
            b=mid;
            left=mid+1;
            }
            else if(nums[mid]<target)
            left=mid+1;
            else
            right=mid-1;
        }  
        return new int[]{a,b};
    }
}
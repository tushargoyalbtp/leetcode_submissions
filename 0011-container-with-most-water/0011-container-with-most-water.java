class Solution {
    public int maxArea(int[] nums) {
        int ans=0;
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(nums[j]>nums[i]){
                ans=Math.max(ans,(j-i)*nums[i]);
                i++;
            }
            else if(nums[i]>nums[j]){
                ans=Math.max(ans,(j-i)*nums[j]);
                j--;
            }else{
                ans=Math.max(ans,(j-i)*nums[i]);
                j--;
                i++;
            }
            
        }
        return ans;
    }
}
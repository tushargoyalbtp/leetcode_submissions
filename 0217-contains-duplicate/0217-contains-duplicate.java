class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = 1;

        int n = nums.length;
        while(j<n){
            if(nums[i] == nums[j]){
                return true;
            }

            i++;
            j++;
        }

        return false;
    }
}
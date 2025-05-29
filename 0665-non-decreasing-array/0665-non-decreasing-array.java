class Solution {
    public boolean checkPossibility(int[] nums) {
        // int countleft = 0;
        // for(int i = 0; i < nums.length-1; i++){
        //     if(nums[i] > nums[i+1]){
        //         countleft++;
        //     }
        // }

        // System.out.println(countleft);

        // int countright = 0;
        // for(int i = nums.length - 2; i >= 0; i--){
        //     if(nums[i] < nums[i+1]){
        //         countright++;
        //     }
        // }

        // System.out.println(countright);

        // int absDiff = Math.abs(countleft - countright);

        // if(absDiff == 1){
        //     return true;
        // }
        // return false;

        // int i = 0 ;
        // int j = nums.length - 1;
        int count = 0;

        // for(int i = 0 ; i < nums.length - 1; i++){
        //     if(nums[i] >= nums[i+1]){
        //         count++;
        //     }
        // }

        // if(count > 1){
        //     return false;
        // }
        // return true;

        // while(i <= j){
        //     if(nums[i] > nums[j]){
        //         count++;
        //         i++;
        //     }
        //     else if(nums[i] <= nums[j]){
        //         j--;
        //     }
        //     else{
        //         i++;
        //         j--;
        //     }
        // }
        // if(count > 1){
        //     return false;
        // }
        // else {
        //     return true;
        // }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1)
                    return false;

                // Try to "fix" nums[i] or nums[i+1]
                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i]; // Modify nums[i+1]
                } else {
                    nums[i] = nums[i + 1]; // Modify nums[i]
                }
            }
        }
        return true;

    }
}
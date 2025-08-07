class Solution {
    public int[] findErrorNums(int[] nums) {
        
        // int[] ans = new int[2];

        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int i = 0; i < nums.length; i++){
        //     if(map.containsKey(nums[i])){
        //         ans[0] = nums[i];
        //         break;
        //     }

        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        // }

        // for(int i = 0; i < nums.length; i++){
        //     if(!map.containsKey(nums[i])){
        //         map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        //     }
        // }


        // for(int i = 1; i <= nums.length; i++){

        //     if(!map.containsKey(i)){
        //         ans[1] = i;
        //         break;
        //     }
        // }

        // return ans;

       int dup = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                dup = val; // FIX: use absolute value
            } else {
                nums[val - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{dup, missing};
    }
}
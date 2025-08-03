class Solution {
    public int findDuplicate(int[] nums) {
        
        // HashMap<Integer,Integer> map = new HashMap<>();

        // int ans = 0;

        // for(int i = 0; i < nums.length; i++){

        //     if(map.containsKey(nums[i])){

        //         ans = nums[i];

        //         break;

        //     }

        //     else{

        //         map.put(nums[i], map.getOrDefault(nums[i],0)+1);

        //     }

        // }

        // return ans;

        // Most optimized

        int slow = 0;
        int fast = 0;
        do{
            
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while(slow!=fast);

        fast = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
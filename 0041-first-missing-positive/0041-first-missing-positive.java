class Solution {
    public int firstMissingPositive(int[] nums) {

        if(nums.length == 1 && nums[0] <= 0){
            return 1;
        }
        
        Arrays.sort(nums);

        if(nums[nums.length-1] <= 0){
            return 1;
        }
        
        int end = nums[nums.length - 1];
        
        HashMap<Integer,Integer> mapCount = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            mapCount.put(nums[i], mapCount.getOrDefault(nums[i], 0)+1);
        }


        for(int i=1; i<=end; i++){
            if(!mapCount.containsKey(i)){
                return i;
            }
        }

        return nums[nums.length - 1] + 1;

    }
}
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
        
//         int[] ans = new int[2];
        
//         HashMap<Integer,Integer> map = new HashMap<>();
        
//         for(int i = 0 ; i < nums.length; i++){
//             if(map.containsKey(target-nums[i])){
//                 ans = new int[]{map.get(target-nums[i]), i};
//                 break;
//             }

//             map.put(nums[i], i);
//         }

//         return ans;
    
//     }
// }


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // value
            pairs[i][1] = i;       // original index
        }
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]); // sort by value
        
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            
            if (sum == target) {
                return new int[] { pairs[left][1], pairs[right][1] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[0]; // no solution
    }
}
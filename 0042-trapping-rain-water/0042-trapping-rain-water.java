class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        int[] left = new int[n];

        int[] right = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];

        for(int i = 1 ; i < n; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }

        for(int i = n - 2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }

        int maxArea = 0;
       for(int i=0;i<height.length;i++){
            maxArea = maxArea  + Math.min(left[i],right[i]) - height[i];
       }

       return maxArea;
    }
}

// [0,1,0,2,1,0,1,3,2,1,2,1]

// left = [0,1,1,2,2,2,2,3,3,3,3,3];
// right = [3,3,3,3,3,3,3,3,2,2,2,1];

// 0 + 0 - 0 = 0
// 0 + 1 - 1 = 0
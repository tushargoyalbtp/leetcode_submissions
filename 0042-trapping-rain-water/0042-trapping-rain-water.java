class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        int[] leftheight = new int[n];

        leftheight[0] = height[0];

        int[] rightheight = new int[n];
        rightheight[n-1] = height[n-1];

        for(int i = 1; i < n; i++){
            leftheight[i] = Math.max(height[i], leftheight[i-1]);
        }

        for(int i = n-2; i>=0; i--){
            rightheight[i] = Math.max(height[i], rightheight[i+1]);
        }

        int maxArea = 0;

        for(int i = 0; i < n ; i++){
            maxArea = maxArea + Math.min(leftheight[i], rightheight[i]) - height[i];
        }

        return maxArea;
    }
}
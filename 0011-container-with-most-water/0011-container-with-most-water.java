class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int globalArea = 0;

        while(left < right){
            
            int width = right - left;
            
            int length = Math.min(height[right], height[left]);

            globalArea = Math.max(globalArea,width * length);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }

        }

        return globalArea;
    }
}
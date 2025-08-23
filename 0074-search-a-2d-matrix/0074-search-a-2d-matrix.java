class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        int i = 0;

        while( i < n){
            int left = 0;
            int right = matrix[i].length - 1;

            while(left <= right){
                int mid = (right+left)/2;
                if(matrix[i][mid] == target){
                    return true;
                }
                else if(matrix[i][mid] < target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            i++;
        }

        return false;
    }
}
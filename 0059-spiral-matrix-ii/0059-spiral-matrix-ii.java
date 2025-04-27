// class Solution {
//     public int[][] generateMatrix(int n) {

//         int[][] matrix = new int[n][n];

//         int start = 1;
//         int end = n*n;
//         int row = 0;
//         int col = 0;
//         int maxCol = n-1;
//         int maxRow = n-1;
//         int cntE = 0;
//         int totalElements = n*n;

//         while(start <=  end){
            

//             for(int j=col, i=row; j<=maxCol && start<=end; j++){
//                 matrix[i][j] = start;
          
//                 start++;
//             }

//             row++;

//             for(int i=row, j=maxCol; i<=maxRow && start<=end; i++){
//                 matrix[i][j] = start;
//                 start++;
//             }

//             maxCol--;

//             for(int j=maxCol, i=maxRow; j>=col && start<=end; j--){
//                 matrix[i][j] = start;
//                 start++;
//             }

//             maxRow--;

//             for(int i=maxRow, j=col; i>=row && start<=end; i--){
//                 matrix[i][j] = start;
                
//                 start++;
//                 System.out.println("start value: "+ start);

//             }

     

//             col++;
            
//         }

//         return matrix;
//     }
// }

class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int d = 0;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;

        while (count <= n * n) {
            if (d == 0) {
                for (int t = left; t <= right; t++) {
                    arr[top][t] = count;
                    count++;
                }
                top++;
            } else if (d == 1) {
                for (int i = top; i <= bottom; i++) {
                    arr[i][right] = count;
                    count++;
                }
                right--;
            } else if (d == 2) {
                for (int t = right; t >= left; t--) {
                    arr[bottom][t] = count;
                    count++;
                }
                bottom--;
            } else if (d == 3) {
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = count;
                    count++;
                }
                left++;
            }
            d = (d + 1) % 4;
        }

        return arr;
    }
}
class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int start = 1;
        int end = n*n;
        int row = 0;
        int col = 0;
        int maxCol = n-1;
        int maxRow = n-1;
        int cntE = 0;
        int totalElements = n*n;

        while(start <=  end){
            

            for(int j=col, i=row; j<=maxCol && start<=end; j++){
                matrix[i][j] = start;
          
                start++;
            }

            row++;

            for(int i=row, j=maxCol; i<=maxRow && start<=end; i++){
                matrix[i][j] = start;
                start++;
            }

            maxCol--;

            for(int j=maxCol, i=maxRow; j>=col && start<=end; j--){
                matrix[i][j] = start;
                start++;
            }

            maxRow--;

            for(int i=maxRow, j=col; i>=row && start<=end; i--){
                matrix[i][j] = start;
                
                start++;
                System.out.println("start value: "+ start);

            }

     

            col++;
            
        }

        return matrix;
    }
}
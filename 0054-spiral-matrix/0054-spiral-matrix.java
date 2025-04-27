class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = 0;
        int col = 0;
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;
        int te = matrix.length * matrix[0].length;
        int cntE = 0;

        while(cntE < te){

            for(int j=col, i=row; j<=maxCol && cntE < te; j++){
                ans.add(matrix[i][j]);
                cntE++;

            }
            
            row++;
            for(int i=row, j=maxCol; i<=maxRow && cntE < te; i++){
                ans.add(matrix[i][j]);
                cntE++;
            }

            maxCol--;
            
            for(int j=maxCol, i=maxRow; j>=col && cntE < te; j--){
                ans.add(matrix[i][j]);
                cntE++;
            }

            maxRow--;

            for(int i=maxRow, j=col; i>=row && cntE < te; i--){
                ans.add(matrix[i][j]);
                cntE++;
            }

            col++;
        }

        return ans;
    }
}
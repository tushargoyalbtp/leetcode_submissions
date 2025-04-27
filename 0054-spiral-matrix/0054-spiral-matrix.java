class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = 0, col = 0;
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;

        while (row <= maxRow && col <= maxCol) {

            for (int j = col; j <= maxCol; j++) {
                ans.add(matrix[row][j]);
            }
            row++;

            for (int i = row; i <= maxRow; i++) {
                ans.add(matrix[i][maxCol]);
            }
            maxCol--;

            if (row <= maxRow) {
                for (int j = maxCol; j >= col; j--) {
                    ans.add(matrix[maxRow][j]);
                }
                maxRow--;
            }

            if (col <= maxCol) {
                for (int i = maxRow; i >= row; i--) {
                    ans.add(matrix[i][col]);
                }
                col++;
            }
        }
        return ans;
    }
}

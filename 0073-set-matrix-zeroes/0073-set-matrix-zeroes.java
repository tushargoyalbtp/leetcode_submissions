class Solution {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        List<int[]> zeros = new ArrayList<>();

        // Store all original zero positions
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }

        // Zero out corresponding rows and columns
        for (int[] pos : zeros) {
            markSurroundingZero(pos[0], pos[1], row, col, matrix);
        }
    }

    public void markSurroundingZero(int i, int j, int row, int col, int[][] matrix) {

        // Zero entire row
        for (int c = 0; c < col; c++) {
            matrix[i][c] = 0;
        }

        // Zero entire column
        for (int r = 0; r < row; r++) {
            matrix[r][j] = 0;
        }
    }
}
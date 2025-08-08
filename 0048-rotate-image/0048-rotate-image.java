class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int k = i; k < n; k++) { // start from i to avoid double swap
                if (k != i) {
                    int temp = matrix[i][k];
                    matrix[i][k] = matrix[k][i];
                    matrix[k][i] = temp; // fixed missing assignment
                }
            }
            reverse(0, n - 1, matrix, i);
        }
    }

    public void swap(int start, int end, int[][] matrix, int row) {
        int temp = matrix[row][start]; // fixed index order
        matrix[row][start] = matrix[row][end];
        matrix[row][end] = temp;
    }

    public void reverse(int start, int end, int[][] matrix, int row) {
        while (start < end) {
            swap(start++, end--, matrix, row);
        }
    }
}

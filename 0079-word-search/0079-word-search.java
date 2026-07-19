class Solution {
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(i, j, row, col, board, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(int i, int j, int row, int col,
                          char[][] board, String word, int index) {

        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found =
                helper(i + 1, j, row, col, board, word, index + 1) ||
                helper(i - 1, j, row, col, board, word, index + 1) ||
                helper(i, j + 1, row, col, board, word, index + 1) ||
                helper(i, j - 1, row, col, board, word, index + 1);

        board[i][j] = temp;

        return found;
    }
}
class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ansList = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfsSolve(board, n, ansList, 0);

        return ansList;

    }

    public void dfsSolve(char[][] board, int n, List<List<String>> ansList, int col) {
        if (col == n) {
            ansList.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafePut(row, col, n, board)) {
                board[row][col] = 'Q';
                dfsSolve(board, n, ansList, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafePut(int row, int col, int n, char[][] board) {
        int dupRow = row;
        int dupCol = col;

        // up left diagonal  
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            row--;
            col--;
        }

        // left  
        col = dupCol;
        row = dupRow;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            col--;
        }

        //down diaginal left
        row = dupRow;
        col = dupCol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<String>();
        


        for(int i=0; i<board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<board.length; j++){
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }

        return res;
    }

}
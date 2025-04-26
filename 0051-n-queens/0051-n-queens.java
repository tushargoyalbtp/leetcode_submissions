class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        
        List<List<String>> ans = new ArrayList<>();
        
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                // List<String> queenPlaces = new ArrayList<>();
                // dfs(i, j, ans, queenPlaces, n);

                board[i][j] = '.';
            }
        }

        dfsSolve(board, ans, n, 0);

        return ans;

    }

    public void dfsSolve(char[][] board, List<List<String>> ans, int n, int col) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                dfsSolve(board, ans, n, col + 1);
                board[row][col] = '.';
            }
        }

    }

    public boolean isSafe(int row, int col, int n, char[][] board) {
        int duprow = row;
        int dupcol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        col = dupcol;
        row = duprow;
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            col--;
        }

        row = duprow;
        col = dupcol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }

            row++;
            col--;
        }

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
class Solution {

    // public int functionHelper(char[][] board, int m, int n, int row, int col){

    //     if(row>=m || col>=n){
    //         return 0;
    //     }
    //     if(board[row][col] == 'X' && row+1 <= m-1 && board[row+1][col] == '.'){
    //         return 1 + functionHelper(board, m, n, row+1, col);
    //     }
    //     if(board[row][col] == 'X' && (col+1 <= n-1 && board[row][col-1]=='.')){
    //         return 1 + functionHelper(board, m, n, row, col+1);
    //     }

    //     return functionHelper(board, m, n, row+1, col) + functionHelper(board, m, n, row, col+1);
    // }
    public int countBattleships(char[][] board) {
        // int m = board.length;
        // int n = board[0].length;

        // return functionHelper(board, m, n, 0, 0);
            int m = board.length;
    int n = board[0].length;
    int count = 0;

    for (int row = 0; row < m; row++) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] == 'X' &&
                (row == 0 || board[row - 1][col] != 'X') &&
                (col == 0 || board[row][col - 1] != 'X')) {
                count++;
            }
        }
    }

    return count;
    }
}



// (1*k) -> 

// (k*1) -> 

// k -> can be of any size

// [
// -> horizontally | vertically 

//     ["X",".",".","X"], 
//     [".",".",".","X"], 
//     [".",".",".","X"]

// ]


// i+1, j+1, vertically and horizontally





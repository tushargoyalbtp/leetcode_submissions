class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;

        boolean[][] visited = new boolean[n][board[0].length];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<board[0].length; j++){
                if(dfshelper(i, j, visited, board, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfshelper(int row, int col, boolean[][] visited, char[][] board, String word, int index) {
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length || 
            visited[row][col] || board[row][col] != word.charAt(index) ){
                return false;
        }
        visited[row][col] = true;
        
        boolean found = dfshelper(row+1, col, visited, board, word, index+1) ||
                    dfshelper(row, col+1, visited, board, word, index+1) ||
                    dfshelper(row-1, col, visited, board, word, index+1)  || 
                    dfshelper(row, col-1, visited, board, word, index+1);

        visited[row][col] =  false;           

        return found;
    }
}
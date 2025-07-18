class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    traverse(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void traverse(int i, int j, char[][] grid){
        if(i< 0 || i>= grid.length || j< 0 || j>= grid[0].length || grid[i][j] == '0' || grid[i][j]== '*') return;

        grid[i][j] = '*';
        traverse(i+1, j, grid);
        traverse(i-1, j, grid);
        traverse(i, j+1, grid);
        traverse(i, j-1, grid);
    }
}
class Solution {
    int countEmptyCell = 0;
    int ans = 0;

    public int uniquePathsIII(int[][] grid) {

        int countObstacle = 0;
        int rx = 0;
        int ry = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    countEmptyCell++;
                }
                else if (grid[i][j] == -1) {
                    countObstacle++;
                }
                else if (grid[i][j] == 1) {
                    rx = i;
                    ry = j;
                }
            }
        }

        helper(grid, rx, ry);

        return ans;
    }

    public void helper(int[][] grid, int rx, int ry) {

        if (rx < 0 || ry < 0 ||
            rx >= grid.length || ry >= grid[0].length) {
            return;
        }

        if (grid[rx][ry] == -1 || grid[rx][ry] == -2) {
            return;
        }

        if (grid[rx][ry] == 2) {

            if (countEmptyCell == 0) {
                ans++;
            }

            return;
        }

        int original = grid[rx][ry];

        if (grid[rx][ry] == 0) {
            countEmptyCell--;
        }

        grid[rx][ry] = -2;

        helper(grid, rx + 1, ry);
        helper(grid, rx, ry + 1);
        helper(grid, rx - 1, ry);
        helper(grid, rx, ry - 1);

        // Backtrack
        grid[rx][ry] = original;

        if (original == 0) {
            countEmptyCell++;
        }
    }
}
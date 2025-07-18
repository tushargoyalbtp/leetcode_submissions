class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public void bfs(int ro, int co, char[][] grid, int[][] visited) {
        visited[ro][co] = 1;
        Queue<Pair> que = new LinkedList<Pair>();
        que.add(new Pair(ro, co));

        int n = grid.length;
        int m = grid[0].length;

        while (!que.isEmpty()) {
            int row = que.peek().first;
            int col = que.peek().second;

            que.remove();

            int[] dRow = { -1, 0, 1, 0 };
            int[] dCol = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int nrow = row + dRow[i];
                int ncol = col + dCol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0) {

                    visited[nrow][ncol] = 1;
                    que.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }
}
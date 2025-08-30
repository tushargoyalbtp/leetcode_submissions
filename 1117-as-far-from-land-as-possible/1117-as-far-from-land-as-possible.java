

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();

        // Step 1: add all land cells to queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // Edge case: all water or all land
        if (q.isEmpty() || q.size() == n * n) return -1;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int dist = -1;

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1; // mark visited as land
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist;
    }
}
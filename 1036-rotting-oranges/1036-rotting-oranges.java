class Solution {
    public int orangesRotting(int[][] grid) {
        
        int m = grid.length;

        int n = grid[0].length;

        Queue<int[]> que = new LinkedList<>();

        int fresh = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    que.add(new int[] {i, j, 0});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            time = Math.max(time, t);

            for(int[] dir : dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    fresh--;
                    que.offer(new int[]{nr, nc, t+1});
                }
            }
        }

        return (fresh == 0) ? time : -1;

    }
}
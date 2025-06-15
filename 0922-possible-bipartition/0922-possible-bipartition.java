class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        HashMap<Integer,List<Integer>> adj = new HashMap<Integer,List<Integer>>();

        for(int[] dislike : dislikes){
            int u = dislike[0];
            int v = dislike[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] color = new int[n+1];
        
        Arrays.fill(color, -1);

        for(int i = 1; i <= n; i++){
            if(color[i]==-1){
                if(!bfsCheckBipartite(adj, i, color)){
                    return false;
                }
            }
        }

        return true;

    }

    public boolean bfsCheckBipartite(Map<Integer, List<Integer>> adj, int index, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        color[index] = 1;
        queue.add(index);

        while(!queue.isEmpty()){
             int curr = queue.poll();
            for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
                if (color[neighbor] == -1) {
                    // Assign opposite color to neighbor
                    color[neighbor] = 1 - color[curr];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[curr]) {
                    // Found same color in neighbor — not bipartite
                    return false;
                }
            }
        }
        return true;
    }
}
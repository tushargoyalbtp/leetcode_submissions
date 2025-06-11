class Solution {

    public boolean dfs(int i, List<List<Integer>> adj, HashSet<Integer> set, boolean[] visited, Stack<Integer> stack){
        set.add(i);
        visited[i] = true;
        for(int num : adj.get(i)){
            if(!visited[num] && !dfs(num, adj, set, visited, stack)) return false;
            else if(set.contains(num)){
                return false;
            }
        }

        set.remove(i);
        stack.push(i);
        return true;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numCourses; i++){
        
            adj.add(new ArrayList<>());
        
        }

        for(int[] edges : prerequisites){
            
            adj.get(edges[1]).add(edges[0]);
        
        
        }

for (List<Integer> list : adj) {
    if (list.size() >= 2) {
        System.out.println(list.get(0) + ", " + list.get(1));
    } else if (list.size() == 1) {
        System.out.println(list.get(0));
    } else {
        System.out.println("[]");
    }
}



        boolean[] visited = new boolean[numCourses];
        boolean acyclic = true;

        for(int i = 0; i<numCourses; i++){
            if(!visited[i]){

                HashSet<Integer> set = new HashSet<>();
                acyclic = dfs(i, adj,set, visited, stack);
                if(!acyclic){
                    return new int[]{};
                }
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }

        return ans;
    }
}
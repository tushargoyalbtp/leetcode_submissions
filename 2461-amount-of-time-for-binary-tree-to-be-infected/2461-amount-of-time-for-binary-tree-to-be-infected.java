class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        makeAdjacencyMap(adjMap, root, null);

        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        que.add(start);
        visited.add(start);
        int minute = -1;

        while (!que.isEmpty()) {
            int size = que.size();
            minute++;

            for (int i = 0; i < size; i++) {
                int current = que.poll();
                for (int neighbor : adjMap.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        que.offer(neighbor);
                    }
                }
            }
        }

        return minute;
    }

    public void makeAdjacencyMap(HashMap<Integer, List<Integer>> adjMap, TreeNode root, TreeNode parentNode) {
        if (root == null) return;

        if (parentNode != null) {
            adjMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(parentNode.val);
            adjMap.computeIfAbsent(parentNode.val, k -> new ArrayList<>()).add(root.val);
        }

        makeAdjacencyMap(adjMap, root.left, root);
        makeAdjacencyMap(adjMap, root.right, root);
    }
}

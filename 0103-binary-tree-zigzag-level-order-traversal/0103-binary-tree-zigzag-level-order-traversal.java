/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> ansList = new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        int level = 1;

        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();

            if (level % 2 != 0) {
                List<Integer> list = new ArrayList<>();
                //left to right
                for (int i = 0; i < size; i++) {
                    TreeNode node = que.poll();
                    list.add(node.val);

                    if (node.left != null) {
                        que.add(node.left);
                    }
                    if (node.right != null) {
                        que.add(node.right);
                    }
                }

                ansList.add(list);
                level++;

            } else {
                // right to left

                List<Integer> list = new ArrayList<>();
                //left to right
                for (int i = 0; i < size; i++) {
                    TreeNode node = que.poll();
                    list.add(node.val);

                    if (node.left != null) {
                        que.add(node.left);
                    }
                    if (node.right != null) {
                        que.add(node.right);
                    }
                }

                List<Integer> list2 = new ArrayList<>();
                for(int i = list.size() - 1 ; i >= 0 ; i--){
                    list2.add(list.get(i));
                }
                ansList.add(list2);
                level++;
            }
        }

        return ansList;

    }
}
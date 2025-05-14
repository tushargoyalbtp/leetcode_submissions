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

        List<List<Integer>> ansList = new ArrayList<>();
        if(root==null){
            return ansList;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            
            if (i % 2 != 0) {
                Collections.reverse(list);
                ansList.add(list);
            } else {
                ansList.add(list);
            }
            i++;
        }

        return ansList;
    }

    // public List<Integer> reverseList(List<Integer> list){
    //     List<Integer> ans = new ArrayList<>();
    //     for(int i = list.size() - 1; i>=0; i--){
    //         ans.add(list.get(i));
    //     }

    //     return ans;
    // }
}
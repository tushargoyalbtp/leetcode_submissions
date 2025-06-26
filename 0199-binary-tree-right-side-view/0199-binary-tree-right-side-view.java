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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        if(root.left == null && root.right == null){
            List<Integer> list1 = new ArrayList<>();
            list1.add(root.val);
            return list1;
        }
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();

        List<Integer> ans = new ArrayList<>();
        
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                list.add(node.val);

                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }

            ans.add(list.get(list.size()-1));
        }

        return ans;
    }
}
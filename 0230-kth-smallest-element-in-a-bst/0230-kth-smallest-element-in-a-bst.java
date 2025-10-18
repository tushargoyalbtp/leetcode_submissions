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
    public int kthSmallest(TreeNode root, int k) {
        int ans = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        preorder(root,queue);

        for(int i = 0; i < k ;i++){
            ans = queue.poll();
        }

        return ans;
    }

    public void preorder(TreeNode root, PriorityQueue<Integer> queue){
        if(root == null){
            return;
        }

        preorder(root.left, queue);
        queue.add(root.val);
        preorder(root.right, queue);
        
    }
}
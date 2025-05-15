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

    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxheight = new int[1];
        height(root, maxheight);
        return maxheight[0];
    }

    public int height(TreeNode root, int[] maxheight){
        if(root == null){
            return 0;
        }

        int lh = height(root.left, maxheight);
        int rh = height(root.right, maxheight);

        maxheight[0] = Math.max(maxheight[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }
}
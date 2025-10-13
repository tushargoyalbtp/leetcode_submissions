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
    public boolean isSymmetric(TreeNode root) {
        // if(root == null){
        //     return true;
        // }

        // return helper(root.left, root.right);

        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    // public boolean helper(TreeNode root1, TreeNode root2){
    //     if(root1==null && root2==null){
    //         return true;
    //     }
    //     if(root1!=null && root2 == null){
    //         return false;
    //     }

    //     if(root1==null && root2 != null){
    //         return false;
    //     }


    //     if(root1.val != root2.val){
    //         return false;
    //     }
    //     return helper(root1.left, root2.right) && helper(root1.right , root2.left);
    // }
}
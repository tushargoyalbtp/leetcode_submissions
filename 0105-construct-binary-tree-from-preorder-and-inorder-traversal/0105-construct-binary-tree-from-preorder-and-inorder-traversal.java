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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        return helper(map, preorder, 0, preorder.length-1, inorder, 0 , inorder.length-1);
    }

    public TreeNode helper(HashMap<Integer,Integer> map, int[] preorder, int prestart, int prend, int[] inorder, int instart, int inend){
        
        if(prestart > prend || instart > inend) return null;

        TreeNode root = new TreeNode(preorder[prestart]);

        int inRoot = map.get(root.val);
        int numleft = inRoot - instart;

        root.left = helper(map, preorder, prestart+1, prestart+numleft, inorder, instart, inRoot-1);
        root.right = helper(map,preorder, prestart+numleft+1, prend, inorder, inRoot+1, inend);

        return root;
    }
}




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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));

        // if(root1==null && root2==null){
        //     return true;
        // }
        // if(root1==null || root2==null){
        //     return false;
        // }
        // List<Integer> rootreverse = flippingTree(root1); 

        // List<Integer> root2List =flippingTreeRoot2(root2);

        // if(rootreverse.size()  != root2List.size()){
        //     return false;
        // }

        // else{

        //     for(int i = 0 ; i < rootreverse.size(); i++){
        //         System.out.print(rootreverse.get(i) +" ");

        //     }

        //       System.out.println();
        //     for(int i = 0 ; i < rootreverse.size(); i++){
        //         System.out.print(root2List.get(i) +" ");   

        //     }
                
        //     for(int i = 0 ; i < rootreverse.size(); i++){
        //         if(rootreverse.get(i) != root2List.get(i)){
        //             return false;
        //         }
        //     }
        // }

        // return true;
    }

    //     public List<Integer> flippingTreeRoot2(TreeNode root){

    //     List<Integer> ansList = new ArrayList<>();

    //     Queue<TreeNode> que = new LinkedList<>();
        
    //     que.add(root);

    //     while(!que.isEmpty()){
    //         int size = que.size();

    //         List<Integer> list = new ArrayList<>();
            
    //         for(int i = 0; i < size; i++){
    //             TreeNode node = que.poll();
    //             list.add(node.val);

    //             if(node.left != null){
    //                 que.add(node.left);
    //             }

    //             if(node.right != null){
    //                 que.add(node.right);
    //             }

    //         }

    //         for(int i = 0; i < list.size(); i++) {
    //             ansList.add(list.get(i));
    //         }
    //     }

    //     return ansList;
    // }

    // public List<Integer> flippingTree(TreeNode root){

    //     List<Integer> ansList = new ArrayList<>();

    //     Queue<TreeNode> que = new LinkedList<>();
        
    //     que.add(root);

    //     while(!que.isEmpty()){
    //         int size = que.size();

    //         List<Integer> list = new ArrayList<>();
            
    //         for(int i = 0; i < size; i++){
    //             TreeNode node = que.poll();
    //             list.add(node.val);

    //             if(node.left != null){
    //                 que.add(node.left);
    //             }

    //             if(node.right != null){
    //                 que.add(node.right);
    //             }

    //         }

    //         Collections.reverse(list);

    //         for(int i = 0; i < list.size(); i++) {
    //             ansList.add(list.get(i));
    //         }
    //     }

    //     return ansList;
    // }


}
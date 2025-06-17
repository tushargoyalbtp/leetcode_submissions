/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ansList = new ArrayList<>();
        if(root==null){
            return ansList;
        }

        HashMap<TreeNode,TreeNode> mapTreeNode = new HashMap<>();
        findParent(mapTreeNode, root);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            int countdis = 0;
            for(int i = 0; i < size; i++){
                TreeNode currnode = queue.poll();
                visited.add(currnode);
                if(k == 0){
                    ansList.add(currnode.val);
                } 
                if(mapTreeNode.containsKey(currnode) && !visited.contains(mapTreeNode.get(currnode))){
                    queue.add(mapTreeNode.get(currnode));
                }
                if(currnode.left!=null && !visited.contains(currnode.left)){
                    queue.add(currnode.left);
                }
                if(currnode.right!=null && !visited.contains(currnode.right)){
                    queue.add(currnode.right);
                }
                
            }
            k--;
            if(k<0){
                break;
            }
        }

        return ansList;

    }

    public void findParent(HashMap<TreeNode, TreeNode> mapTree, TreeNode root){
        if(root==null){
            return;
        }

        if(root.left!=null){
            mapTree.put(root.left, root);
        }

        if(root.right!=null){
            mapTree.put(root.right, root);
        }

        findParent(mapTree, root.left);
        findParent(mapTree, root.right);
        return;
    }
}
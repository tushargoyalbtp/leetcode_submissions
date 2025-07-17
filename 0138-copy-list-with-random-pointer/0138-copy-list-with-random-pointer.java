/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> mapNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node temp = new Node(head.val);
        mapNode.put(head, temp);
        temp.next = copyRandomList(head.next);
        temp.random = mapNode.get(head.random);
        return temp;     
    }
}
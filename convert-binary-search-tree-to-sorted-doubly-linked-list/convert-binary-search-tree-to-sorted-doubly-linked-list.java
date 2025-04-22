// LeetCode: Convert Binary Search Tree to Sorted Doubly Linked List (convert-binary-search-tree-to-sorted-doubly-linked-list)
// Submission ID: 1614571564
// Language: java
// Timestamp (UTC): 2025-04-22T11:59:27Z

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public static void inOrder(Node root,List<Node>list){
        if(root == null)return;

        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);

    }
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
if (root.left == null && root.right == null) {
    root.left = root;
    root.right = root;
    return root;
}
        
        List<Node>list = new ArrayList<>();

        inOrder(root,list);
        

        Node head = list.get(0);
        Node tail = list.get(list.size()-1);

        for(int i = 0; i<list.size()-1; i++){
                Node first = list.get(i);
                Node sec = list.get(i+1);
                first.right = sec;
                sec.left = first;
        }

        head.left = tail;
        tail.right = head;

        return head;


        
    }
}
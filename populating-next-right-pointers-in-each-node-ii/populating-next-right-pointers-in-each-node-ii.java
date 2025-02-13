// LeetCode: Populating Next Right Pointers in Each Node II (populating-next-right-pointers-in-each-node-ii)
// Submission ID: 1542113357
// Language: java
// Timestamp (UTC): 2025-02-13T18:33:47Z

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size()!=0){
            int size = q.size();
            ArrayList<Node> subAns = new ArrayList<>();
            while(size--!=0){
                Node rem = q.poll();
                subAns.add(rem);

                if(rem.left!=null)q.add(rem.left);

                if(rem.right!=null)q.add(rem.right);

            }

            if(subAns.size()!=1){

                for(int i = 1; i<subAns.size(); i++){
                    Node n1 = subAns.get(i-1);
                    Node n2 = subAns.get(i);
                    n1.next = n2;
                }
            }
        }

         return root;
    }
}
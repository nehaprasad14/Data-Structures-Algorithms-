// non-recursive java program for inorder traversal
 
/* importing the necessary class
	
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
    a) Pop the top item from stack.
    b) Print the popped item, set current = popped_item->right 
    c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
	
	*/
import java.util.Stack;
 
/* Class containing left and right child of current 
 node and key value*/
class Node {
 
    int data;
    Node left, right;
 
    public Node(int item) {
        data = item;
        left = right = null;
    }
}
 
/* Class to print the inorder traversal */
class BinaryTree {
 
    Node root;
 
    void inorder() {
        if (root == null) {
            return;
        }
        
        //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
         
        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
 
    public static void main(String args[]) {
         
        /* creating a binary tree and entering 
         the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorder();
    }
}
 

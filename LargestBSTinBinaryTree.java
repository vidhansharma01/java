import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int key;
        Node left,right;
        public Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    static class Value{
        int max_size;
        boolean is_bst;
        int min;
        int max;
        public Value(){
            max_size = 0;
            is_bst = true;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }
    static Node root;
    public BinaryTree(){

    }
    public static int largestBST(Node root){
        Value val = largest(root);
        return val.max_size;
    }
    public static Value largest(Node root){
        if (root == null)
            return new Value();

        Value left = largest(root.left);
        Value right = largest(root.right);

        Value val = new Value();

        if(left.is_bst == false || right.is_bst == false ||
                (left.max > root.key) || (right.min <= root.key)){
            val.is_bst = false;
            val.max_size = Math.max(left.max_size, right.max_size);
            return val;
        }
        val.is_bst = true;
        val.max_size = left.max_size + right.max_size + 1;
        val.min = root.left != null ? left.min : root.key;
        val.max = root.right != null ? right.max : root.key;

        return val;
    }

    public static void main(String args[]){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(10);
        tree.root.right = new Node(60);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(20);
        tree.root.right.left = new Node(55);
        tree.root.right.left.left = new Node(45);
        tree.root.right.right = new Node(70);
        tree.root.right.right.left = new Node(65);
        tree.root.right.right.right = new Node(80);

        System.out.println(largestBST(root));

    }
}

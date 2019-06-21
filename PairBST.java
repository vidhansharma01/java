package tree;

import java.util.Stack;
//Count pairs from two BSTs whose sum is equal to a given value x
public class PairBST {
    static class Node{
        int key;
        Node left, right;
        public Node(int key){
            this.key = key;
            left = right = null;
        }
    }
    static Node root1;
    static Node root2;

    public static int countPairs(Node root1, Node root2, int x){
        if(root1 == null || root2 == null) return 0;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node top1, top2;
        int count = 0;
        while (true){
            while (root1 != null){
                stack1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null){
                stack2.push(root2);
                root2 = root2.right;
            }

            if (stack1.isEmpty() || stack2.isEmpty())
                break;

            top1 = stack1.peek();
            top2 = stack2.peek();

            if (top1.key + top2.key == x){
                count++;
                stack1.pop();
                stack2.pop();

                root1 = top1.right;
                root2 = top2.left;
            }else if ((top1.key + top2.key) < x) {
                stack1.pop();
                root1 = top1.right;
            }else{
                stack2.pop();
                root2 = top2.left;
            }
        }
        return count;
    }

    public static void main(String args[]){
        root1 = new Node(5);       /*            5        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(7); /*         3     7     */
        root1.left.left = new Node(2); /*    / \   / \    */
        root1.left.right = new Node(4); /*  2   4 6   8    */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        root2 = new Node(10);        /*          10         */
        root2.left = new Node(6); /*           /   \        */
        root2.right = new Node(15); /*        6     15      */
        root2.left.left = new Node(3); /*    / \   /  \     */
        root2.left.right = new Node(8); /*  3  8  11  18    */
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        System.out.println(countPairs(root1, root2, 16));
    }
}

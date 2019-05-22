public class Stack {
    static StackNode root;
    static class StackNode{
        int data;
        StackNode next;
        public StackNode(int data){
            this.data = data;
        }
    }
    public static boolean isEmpty(){
        if (root == null)
            return true;
        else
            return false;
    }
    public static void push(int data){
        StackNode new_node = new StackNode(data);
        if (root == null)
            root = new_node;
        else{
            new_node.next = root;
            root = new_node;
        }
        System.out.println(data + " pushed to stack");
    }
    public static int pop(){
        int pop = Integer.MIN_VALUE;
        if (root == null)
            System.out.println("Stack is empty");
        else{
            pop = root.data;
            root = root.next;
        }
        return pop;
    }
    public static int peek(){
        if (root == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        } else {
            return root.data;
        }
    }
    public static void main(String args[]){
        push(10);
        push(20);
        push(30);
        System.out.println(pop() + " popped from stack");
        System.out.println("top element : " + peek());
    }
}

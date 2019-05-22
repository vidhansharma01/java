public class DoublyLinkedList {
    static Node head;
    static class Node{
        int data;
        Node prev;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    //deleting a node in doubly LL
    public static void deleteNode(Node node, Node del){
        head = node;
        if (head == null || del == null)
            return;
        if (head == del)
            head = del.next;
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }
    //printing doubly LL
    public static void printList(Node node){
        Node last = null;
        while (node != null){
            if (node.next != null)
                System.out.print(node.data + "->");
            else
                System.out.println(node.data);
            last = node;
            node = node.next;
        }
//        while (last != null){
//            if (last.prev != null)
//                System.out.print(last.data+ "->");
//            else
//                System.out.println(last.data);
//            last = last.prev;
//        }
    }
    //adding a node at the end
    public static void append(int new_data){
        Node new_node = new Node(new_data);
        Node last = head;
        new_node.next = null;
        if (head == null){
            new_node.prev = null;
            head = new_node;
            return;
        }
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        new_node.prev = last;
    }
    //adding a node after a given node
    public static void insertAfter(Node prev_Node, int new_data){
        Node new_node = new Node(new_data);
        new_node.next = prev_Node.next;
        prev_Node.next = new_node;
        new_node.prev = prev_Node;
        if (new_node.next != null)
            new_node.next.prev = new_node;
    }
    //adding a node in front
    public static void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;

        if (head != null)
            head.prev = new_node;

        head = new_node;
    }
    //Main function
    public static void main(String args[]){
        DoublyLinkedList dll = new DoublyLinkedList();
        push(2);
        push(4);
        push(8);
        push(10);
        printList(head);
        deleteNode(head, head.next);
        printList(head);
    }
}

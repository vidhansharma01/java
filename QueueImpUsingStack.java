import java.util.Stack;

public class QueueImpUsingStack {
    static class Queue{
        Stack<Integer> s1 = new Stack<>();
    }
    public static void enQueue(Queue q, int data){
        q.s1.push(data);
    }
    public static int deQueue(Queue q){
        if (q.s1.isEmpty()){
            System.out.println("Q is empty");
            System.exit(0);
        }
        else if (q.s1.size() == 1){
            return q.s1.pop();
        }else{
            int x = q.s1.pop();
            int res = deQueue(q);
            q.s1.push(x);
            return res;
        }
        return 0;
    }

    public static void main(String args[]){
        Queue q =  new Queue();
        enQueue(q,10);
        enQueue(q,20);
        enQueue(q,30);
        System.out.println(deQueue(q));
        System.out.println(deQueue(q));
        System.out.println(deQueue(q));
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueDemo {
    public static void main(String[] args) {
        // Stack Example (LIFO)
        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack Example:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushes: " + stack);

        int popped = stack.pop();
        System.out.println("Popped from stack: " + popped);
        System.out.println("Stack after pop: " + stack);

        int peeked = stack.peek();
        System.out.println("Peeked from stack: " + peeked);
        System.out.println("Stack after peek: " + stack);

        // Queue Example (FIFO)
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("\nQueue Example:");
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Queue after offers: " + queue);

        int removed = queue.poll();
        System.out.println("Removed from queue: " + removed);
        System.out.println("Queue after poll: " + queue);

        int head = queue.peek();
        System.out.println("Peeked from queue: " + head);
        System.out.println("Queue after peek: " + queue);
    }
}
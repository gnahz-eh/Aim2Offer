import java.util.Stack;

/**
 * Created by Administrator on 2017/3/3.
 */


class Queue<T> {
    public Stack<T> stack1;
    public Stack<T> stack2;

    public Queue() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }

    public void appendTail(T element) {
        stack1.push(element);
    }
    public T deleteHead() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                T element = stack1.peek();
                stack1.pop();
                stack2.push(element);
            }
        }

        if (stack2.size() == 0)
            return null;
        T head = stack2.peek();
        stack2.pop();
        return head;
    }
}

public class QueueWithTwoStacks<T> {
    public Queue<T> queue;

    public static void main (String[] args) {
        QueueWithTwoStacks<Integer> q = new QueueWithTwoStacks<>();
        q.queue = new Queue<Integer>();
        for (int i = 0; i < 10; i++) {
            q.queue.appendTail(i);
        }
        for (int i = 0; i < 10; i++) {
            int element = q.queue.deleteHead();
            System.out.print(element + " ");
        }
    }
}




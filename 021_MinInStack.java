import java.util.Stack;

/**
 * Created by Administrator on 2017/3/6.
 */
public class MinInStack {

    private Stack<Integer> data;
    private Stack<Integer> min;

    public MinInStack() {
        this.data = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    public void push(int val) {
        data.push(val);
        if (min.size() == 0 || val < min.peek())
            min.push(val);
        else
            min.push(min.peek());
    }

    public int pop() {
        if (!data.empty()) {
            min.pop();
            return data.pop();
        } else
            return -1;
    }

    public int min() {
        if (data.size() > 0)
            return min.peek();
        else return -1;
    }

    public static void main(String[] args) {
        MinInStack m = new MinInStack();
        m.push(3);
        System.out.println(m.min());
        m.push(4);
        System.out.println(m.min());
        m.push(2);
        System.out.println(m.min());
        m.push(1);
        System.out.println(m.min());
        m.pop();
        System.out.println(m.min());
        m.pop();
        System.out.println(m.min());
        m.push(0);
        System.out.println(m.min());
    }
}

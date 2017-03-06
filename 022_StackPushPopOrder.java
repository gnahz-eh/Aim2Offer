import java.util.Stack;

/**
 * Created by Administrator on 2017/3/6.
 */
public class StackPushPopOrder {

    boolean isPopOrder (int[] push, int[] pop) {
        boolean bPossible = false;

        if (push != null && pop != null && push.length > 0) {
            int nextPushIdx = 0;
            int nextPopIdx = 0;
            Stack<Integer> stack = new Stack<>();

            while (nextPopIdx < pop.length) {
                while (stack.empty() || stack.peek() != pop[nextPopIdx]) {
                    if (nextPushIdx == push.length)
                        break;
                    stack.push(push[nextPushIdx]);
                    nextPushIdx++;
                }
                if (stack.peek() != pop[nextPopIdx])
                    break;

                stack.pop();
                nextPopIdx++;
            }
            if (stack.empty() && nextPopIdx == pop.length)
                bPossible = true;
        }
        return bPossible;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4};
        int[] pop = {4,3,1,2};

        StackPushPopOrder s = new StackPushPopOrder();
        System.out.println(s.isPopOrder(push, pop));
    }
}

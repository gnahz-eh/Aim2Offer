import java.util.Stack;

/**
 * Created by Administrator on 2017/3/2.
 */

class ListNode {
    public int val;
    public ListNode next;

    public ListNode () {
        this.val = 0;
        this.next = null;
    }

    public ListNode (int val) {
        this.val = val;
        this.next = null;
    }
}

public class PrintListInReversedOrder {

    // use a stack to store the elements;
    public void printListReversingly (ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (!stack.empty()) {
            ListNode node = stack.peek();
            System.out.print(node.val + " ");
            stack.pop();
        }
    }

    public void printListReversingly2 (ListNode head) {
        if (head != null) {
            if (head.next != null)
                printListReversingly2(head.next);
            System.out.print(head.val + " ");
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        PrintListInReversedOrder p = new PrintListInReversedOrder();

        p.printListReversingly(l1);
        System.out.println();
        p.printListReversingly2(l1);
    }
}

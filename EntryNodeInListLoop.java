/**
 * Created by Administrator on 2017/3/15.
 */

class ListNode {
    public int val;
    public ListNode next;
    public ListNode sibling;

    public ListNode () {
        this.val = 0;
        this.next = null;
        this.sibling = null;
    }

    public ListNode (int val) {
        this.val = val;
        this.next = null;
        this.sibling = null;
    }
}

public class EntryNodeInListLoop {

    private ListNode meetingNode(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = slow.next;

        while (fast != null && slow != null) {
            if (fast == slow)
                return fast;

            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return null;
    }

    public ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;
        int nodesInLoop = 1;
        ListNode temp = meetingNode;
        while (temp.next != meetingNode) {
            temp = temp.next;
            ++nodesInLoop;
        }

        ListNode fast = head;
        for (int i = 0; i < nodesInLoop; i++)
            fast = fast.next;

        ListNode slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l1;

        EntryNodeInListLoop e = new EntryNodeInListLoop();
        System.out.print(e.entryNodeOfLoop(l1).val);
    }
}

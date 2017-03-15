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

public class DeleteDuplicatedListNode {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val)
                head = head.next;
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }


    public void show(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        DeleteDuplicatedListNode d = new DeleteDuplicatedListNode();
        d.show(l1);
        System.out.println();
        d.show(d.deleteDuplicates(l1));
    }
}


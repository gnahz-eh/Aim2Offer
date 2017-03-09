/**
 * Created by Administrator on 2017/3/9.
 */

class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class FirstCommonNodesInLists {
    ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        int lengthDiff = Math.abs(length1 - length2);
        ListNode headLong = head1;
        ListNode headShort = head2;

        if (length2 > length1) {
            headLong = head2;
            headShort = head1;
        }

        for (int i = 0; i < lengthDiff; ++i) {
            headLong = headLong.next;
        }

        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }

        return headLong;
    }

    public int getLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
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
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l6;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        FirstCommonNodesInLists f = new FirstCommonNodesInLists();
        f.show(l1);
        System.out.println();
        f.show(l4);
        System.out.println();
        System.out.println(f.findFirstCommonNode(l1, l4).val);

    }
}

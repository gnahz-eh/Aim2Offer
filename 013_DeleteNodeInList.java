/**
 * Created by Administrator on 2017/3/5.
 */

class ListNode {
    public int value;
    public ListNode next;

    ListNode (int value) {
        this.value = value;
        this.next = null;
    }

    ListNode () {
        this.value = 0;
        this.next = null;
    }
}

public class DeleteNodeInList {
    // leetcode 237
    public void deleteNode(ListNode head, ListNode toBeDel) {
        if (head == null || toBeDel == null)
            return;

        if (toBeDel.next != null) {
            ListNode pNext = toBeDel.next;
            toBeDel.value = pNext.value;
            toBeDel.next = pNext.next;
        } else if (head == toBeDel) {      // delete head
            head = null;
        } else {
            ListNode temp = head;          // delete tail
            while (temp.next != toBeDel)
                temp = temp.next;
            temp.next = null;
        }
    }

    public void show(ListNode head) {
        if (head == null) return;
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeInList d = new DeleteNodeInList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        d.show(l1);
        d.deleteNode(l1, l5);
        System.out.println();
        d.show(l1);
    }
}

/**
 * Created by Administrator on 2017/3/7.
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

public class CopyComplexList {

    ListNode clone(ListNode head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    void cloneNodes(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            ListNode cloned = new ListNode();
            cloned.val = temp.val;
            cloned.next = temp.next;
            cloned.sibling = null;

            temp.next = cloned;
            temp = cloned.next;
        }
    }

    void connectSiblingNodes(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            ListNode cloned = temp.next;
            if (temp.sibling != null)
                cloned.sibling = temp.sibling.next;
            temp = cloned.next;
        }
    }

    ListNode reconnectNodes(ListNode head) {
        ListNode temp = head;
        ListNode cloneHead = null;
        ListNode cloneNode = null;

        if (temp != null) {
            cloneHead = cloneNode = temp.next;
            temp.next = cloneNode.next;
            temp = temp.next;
        }

        while (temp != null) {
            cloneNode.next = temp.next;
            cloneNode = cloneNode.next;
            temp.next = cloneNode.next;
            temp = temp.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        CopyComplexList c = new CopyComplexList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l1.sibling = l3;
        l2.sibling = l5;
        //l3.sibling = l1;
        l4.sibling = l2;

        ListNode clone = c.clone(l1);
        while (clone != null) {
            if (clone.sibling != null)
                System.out.println(clone.val + "->" + clone.sibling.val);
            clone = clone.next;
        }
    }
}

/**
 * Created by Administrator on 2017/3/5.
 */
public class KthNodeFromEnd {

    public ListNode findKthToTail (ListNode head, int k) {
        if (head == null || k == 0)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (k-- >= 1) {
            if (fast != null)
                fast = fast.next;
            else
                return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
        KthNodeFromEnd k = new KthNodeFromEnd();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        k.show(l1);
        ListNode res = k.findKthToTail(l1, 5);
        System.out.println();
        System.out.println(res.value);
    }

}

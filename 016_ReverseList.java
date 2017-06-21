/**
 * Created by Administrator on 2017/3/6.
 */
public class ReverseList {

    public ListNode reverse2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;
        while (p2 != null) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        return p1;
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
        ReverseList r = new ReverseList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = null;
//        l3.next = l4;
//        l4.next = l5;

        r.show(l1);
        ListNode res = r.reverse(l1);
        System.out.println();
//        System.out.println(res.value);
        r.show(res);
    }
}

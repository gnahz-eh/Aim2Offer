/**
 * Created by Administrator on 2017/3/6.
 */
public class MergeSortedLists {
    
    // leetcode 021
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.value < l2.value) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
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
        MergeSortedLists m = new MergeSortedLists();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l3;
        l2.next = l4;
        l3.next = l5;
//        l4.next = l5;

        m.show(l1);
        System.out.println();
        m.show(l2);
        ListNode res = m.merge(l1, l2);
        System.out.println();
//        System.out.println(res.value);
        m.show(res);
    }
}

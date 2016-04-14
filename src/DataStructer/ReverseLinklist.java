package DataStructer;

/**
 * Created by zhangwen on 4/14/16.
 * 翻转链表,保证代码的鲁棒性
 */
public class ReverseLinklist {
    class ListNode {
        ListNode next;
        int data;
    }

    public ListNode ReverseList(ListNode head) {
        //实例化三个指针
        ListNode cur;
        ListNode pre;
        ListNode last;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        pre = head;
        cur = pre.next;
        last = cur.next;
        while (last != null) {
            //先更改指针
            cur.next = pre;
            pre = cur;
            cur = last;
            last = last.next;
        }
        cur.next = pre;
        head.next = null;
        return cur;

    }

}

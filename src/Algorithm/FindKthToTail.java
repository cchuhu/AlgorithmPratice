package Algorithm;

/**
 * Created by zhangwen on 4/13/16.
 * 找到链表的倒数第k个节点,保证代码的鲁棒性
 */
public class FindKthToTail {
    public class ListNode {
        ListNode next;
        int data;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        /**
         * 保证代码的鲁棒性,一定要判断是否非法输入/空输入
         */
        if (head == null || k <= 0) {
            return null;
        }
        //定义两个指针,一个比另一个快k个节点
        ListNode pre = head;
        ListNode after = head;
        //首先将pre指针后移k个节点
        for (int i = 0; i < k - 1; i++) {
            if (pre.next == null) {
                return null;
            } else {
                pre = pre.next;
            }
        }
        //将两个指针同步向后移动
        while (pre.next != null) {
            pre = pre.next;
            after = after.next;
        }
        return after;
    }
}

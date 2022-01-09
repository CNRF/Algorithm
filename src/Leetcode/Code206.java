package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code206
 * @description https://leetcode-cn.com/problems/reverse-linked-list/
 * @date 2022/1/9 11:18
 */
public class Code206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

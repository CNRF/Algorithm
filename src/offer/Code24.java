package offer;

/**
 * @author wmx
 * @version 1.0
 * @className Code24
 * @description https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @date 2022/1/4 15:49
 */
public class Code24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        //临时存放当前节点的下一个节点数据
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

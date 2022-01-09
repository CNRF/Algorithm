package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wmx
 * @version 1.0
 * @className Code19
 * @description https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @date 2022/1/4 9:45
 */
public class Code19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用栈将数据放入栈中，之后遍历删除
        //设置头结点，避免头结点删除的特殊情况
        ListNode listNode = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = listNode;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return listNode.next;
    }

    /**
     * 使用双指针实现
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //使用栈将数据放入栈中，之后遍历删除
        //设置头结点，避免头结点删除的特殊情况
        ListNode listNode = new ListNode(0, head);
        ListNode start = listNode;
        ListNode end = listNode;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        //返回除开第一个增加的节点
        return listNode.next;
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

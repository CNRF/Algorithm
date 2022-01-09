package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code876
 * @description https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @date 2022/1/4 9:32
 */
public class Code876 {
    public static ListNode middleNode(ListNode head) {
        //遍历链表转换成数组
        ListNode[] result = new ListNode[100];
        int index = 0;

        while (head != null) {
            result[index++] = head;
            head = head.next;
        }
        //获取数组的中位数
        return result[index / 2];

    }

    /**
     * Definition for singly-linked list.
     */
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

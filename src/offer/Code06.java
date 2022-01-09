package offer;

import java.util.Stack;

/**
 * @author wmx
 * @version 1.0
 * @className Code06
 * @description https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @date 2022/1/4 15:28
 */
public class Code06 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> result = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            result.push(temp);
            temp = temp.next;
        }
        int size = result.size();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = result.pop().val;
        }
        return ints;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

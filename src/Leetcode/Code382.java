package Leetcode;

import java.util.Random;

/**
 * @author wmx
 * @version 1.0
 * @className Code382
 * @description https://leetcode-cn.com/problems/linked-list-random-node/solution/dai-ma-jie-de-xiao-bai-chou-shui-tang-su-1h6t/
 * 水塘抽样算法
 * https://www.cnblogs.com/krcys/p/9121487.html
 * @date 2022/1/16 10:27
 */
public class Code382 {
    public static void main(String[] args) {
        System.out.println(new Random().nextInt(100));
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

    class Solution {
        ListNode head;
        Random random = new Random(20220116);

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            int res = 0;
            ListNode cur = head;
            int count = 0;
            while (cur != null && ++count > 0) {
                if (random.nextInt(count) == 0) {
                    res = cur.val;
                    cur = head.next;
                }
            }
            return res;
        }
    }
}

package offer;

import java.util.HashMap;

/**
 * @author wmx
 * @version 1.0
 * @className Code35
 * @description https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @date 2022/1/5 14:25
 */
public class Code35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        //将原来链表的数值赋值到map中
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

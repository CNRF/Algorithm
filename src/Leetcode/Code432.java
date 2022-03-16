package Leetcode;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/all-oone-data-structure/
 *
 * @author wmx
 * @version 1.0
 * @className Code432
 * @date 2022/3/16 23:34
 */
public class Code432 {
    class AllOne {
        //Map 存放对应的字符串以及Node节点
        HashMap<String, Node> map;
        // 头尾节点为虚拟节点，方便增加和删除元素，且从小到大排序
        Node head, tail;


        public AllOne() {
            this.map = new HashMap<String, Node>();
            this.head = new Node(null, 0);
            this.tail = new Node(null, Integer.MAX_VALUE);
            head.next = tail;
            tail.prev = head;
        }

        public void inc(String key) {
            if (!map.containsKey(key)) {
                // 不包含这个key，插入一个在头之后
                Node node = new Node(key, 1);
                node.prev = head;
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
                map.put(key, node);
            } else {
                // 包含这个key，数值增加1，并往后移动
                Node node = map.get(key);
                node.val++;
                while (node.val > node.next.val) {
                    // 交换两个节点的位置
                    Node next = node.next;
                    node.next = next.next;
                    next.next.prev = node;
                    node.prev.next = next;
                    next.prev = node.prev;
                    node.prev = next;
                    next.next = node;
                }
            }
        }

        public void dec(String key) {
            // 包含这个key的时候才处理
            if (map.containsKey(key)) {
                Node node = map.get(key);
                if (node.val == 1) {
                    map.remove(key);
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                } else {
                    node.val--;
                    // 往前移动
                    while (node.val < node.prev.val) {
                        Node prev = node.prev;
                        node.prev = prev.prev;
                        prev.prev.next = node;
                        prev.next = node.next;
                        node.next.prev = prev;
                        prev.prev = node;
                        node.next = prev;
                    }
                }
            }
        }

        public String getMaxKey() {
            return tail.prev == head ? "" : tail.prev.key;
        }

        public String getMinKey() {
            return head.next == tail ? "" : head.next.key;
        }

        class Node {
            Node prev;
            Node next;
            String key;
            int val;

            public Node(String key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

}

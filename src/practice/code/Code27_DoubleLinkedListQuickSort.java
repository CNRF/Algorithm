package practice.code;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wmx
 * @version 1.0
 * @className Code27_DoubleLinkedListQuickSort
 * @description 双向链表的随机快速排序
 * @date 2021/12/15 15:52
 */
public class Code27_DoubleLinkedListQuickSort {
    public static Node quickSort(Node h) {
        return h;
    }

    // 为了测试
    public static Node sort(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        arr.sort(new NodeComp());
        Node h = arr.get(0);
        h.last = null;
        Node p = h;
        for (int i = 1; i < arr.size(); i++) {
            Node c = arr.get(i);
            p.next = c;
            c.last = p;
            c.next = null;
            p = c;
        }
        return h;
    }

    // 为了测试
    public static Node generateRandomDoubleLinkedList(int n, int v) {
        if (n == 0) {
            return null;
        }
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node((int) (Math.random() * v));
        }
        Node head = arr[0];
        Node pre = head;
        for (int i = 1; i < n; i++) {
            pre.next = arr[i];
            arr[i].last = pre;
            pre = arr[i];
        }
        return head;
    }

    // 为了测试
    public static Node cloneDoubleLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node h = new Node(head.value);
        Node p = h;
        head = head.next;
        while (head != null) {
            Node c = new Node(head.value);
            p.next = c;
            c.last = p;
            p = c;
            head = head.next;
        }
        return h;
    }

    // 为了测试
    public static boolean equal(Node h1, Node h2) {
        return doubleLinkedListToString(h1).equals(doubleLinkedListToString(h2));
    }

    // 为了测试
    public static String doubleLinkedListToString(Node head) {
        Node cur = head;
        Node end = null;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.value + " ");
            end = cur;
            cur = cur.next;
        }
        builder.append("| ");
        while (end != null) {
            builder.append(end.value + " ");
            end = end.last;
        }
        return builder.toString();
    }

    // 为了测试
    public static void main(String[] args) {
        int N = 500;
        int V = 500;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int size = (int) (Math.random() * N);
            Node head1 = generateRandomDoubleLinkedList(size, V);
            Node head2 = cloneDoubleLinkedList(head1);
            Node sort1 = quickSort(head1);
            Node sort2 = sort(head2);
            if (!equal(sort1, sort2)) {
                System.out.println("出错了!");
                break;
            }
        }
        System.out.println("测试结束");
    }

    //定义链表Node
    public static class Node {
        public int value;
        public Node last;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static class HeadTail {
        public Node h;
        public Node t;

        public HeadTail(Node head, Node tail) {
            h = head;
            t = tail;
        }
    }

    public static class Info {
        public Node lh;
        public Node lt;
        public int ls;
        public Node rh;
        public Node rt;
        public int rs;
        public Node eh;
        public Node et;

        public Info(Node lH, Node lT, int lS, Node rH, Node rT, int rS, Node eH, Node eT) {
            lh = lH;
            lt = lT;
            ls = lS;
            rh = rH;
            rt = rT;
            rs = rS;
            eh = eH;
            et = eT;
        }
    }

    // 为了测试
    public static class NodeComp implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }

    }

}

package code;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code11_ReverseList
 * @description 单链表实现与翻转
 * @date 2021/10/20 16:09
 */
public class Code11_ReverseList {

    /**
     * 传入链表头节点对链表进行翻转之后返回翻转之后的头节点
     *
     * @param head 链表的头结点
     *             head    ->   b    ->  c  ->  null
     *             c    ->   b    ->  head  ->  null
     * @return {@link Node} 翻转链表之后的头节点
     * @author wmx
     * @date 2021/10/20 16:39
     **/
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 通过数组实现链表翻转
     *
     * @param head 链表头节点
     * @return {@link Node }
     * @author code.Code11_ReverseList.Node
     * @date 2021/10/20 16:57
     **/
    public static Node reverseLinkedListArr(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //设置翻转之后尾节点的next为null
        list.get(0).next = null;
        int N = list.size();
        for (int i = 1; i < N; i++) {
            //设置翻转之后的元素的next节点数值
            list.get(i).next = list.get(i - 1);
        }
        //返回数组最后一个Node，此Node为翻转之后的头节点
        return list.get(N - 1);
    }

    /**
     * 生成在最大长度的链表 Node的数值在[-value,+value]之间的数
     *
     * @param len   最大的链表长度
     * @param value Node中数值的范围
     * @return {@link Node} 返回生成链表的头节点
     */
    //for test
    public static Node generateRandomLinkedList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        Node head = new Node((int) (Math.random() * (value + 1)));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }
    //for test

    /**
     * 将传入的头节点的链表按照顺序取出放在数组中返回
     *
     * @param head 链表头节点
     * @return {@link List< Integer>} 链表中按顺序取出的数组
     */
    public static List<Integer> getLinkedListOriginOrder(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return list;
    }

    //for test

    /**
     * 将数组和传入head节点的链表比较是否其中value值相同
     *
     * @param origin 数组
     * @param head   头节点
     * @return {@link boolean}
     * @author wmx
     * @date 2021/10/20 17:20
     **/
    public static boolean checkLinkedListReverse(List<Integer> origin, Node head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int len = 21;
        int value = 100;
        int testTime = 1000;
        System.out.println("开始测试");
        for (int i = 0; i < testTime; i++) {
            Node node1 = generateRandomLinkedList(len, value);
            List<Integer> list1 = getLinkedListOriginOrder(node1);
            node1 = reverseLinkedList(node1);
            if (!checkLinkedListReverse(list1, node1)) {
                System.out.println("翻转方法reverseLinkedList有问题");
            }
            //测试数组翻转方法
            Node node2 = generateRandomLinkedList(len, value);
            List<Integer> list2 = getLinkedListOriginOrder(node2);
            node2 = reverseLinkedListArr(node2);
            if (!checkLinkedListReverse(list2, node2)) {
                System.out.println("数组翻转方法reverseLinkedListArr有问题");
            }
        }
        System.out.println("测试完成");
    }
}

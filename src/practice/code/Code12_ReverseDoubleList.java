package practice.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code12_ReverseDoubleList
 * @description 双向链表以及翻转
 * @date 2021/10/20 17:33
 */
public class Code12_ReverseDoubleList {
    /**
     * 翻转双向链表
     *
     * @param head 头节点
     * @return {@link DoubleNode} 翻转之后链表头节点
     * @author wmx
     * @date 2021/10/20 17:44
     **/
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        return head;
    }

    /**
     * 通过数组翻转双向链表，并返回头节点数据
     *
     * @param head 头结点
     * @return {@link DoubleNode} 反转之后的链表头节点
     * @author wmx
     * @date 2021/10/20 17:46
     **/
    public static DoubleNode reverseDoubleListArr(DoubleNode head) {
        return head;
    }

    //for test
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    // for test
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    // for test
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return false;
            }
            end = head;
            head = head.next;
        }
        for (int i = 0; i < origin.size(); i++) {
            if (!origin.get(i).equals(end.value)) {
                return false;
            }
            end = end.pre;
        }
        return true;
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {

            DoubleNode node3 = generateRandomDoubleList(len, value);
            List<Integer> list3 = getDoubleListOriginOrder(node3);
            node3 = reverseDoubleList(node3);
            if (!checkDoubleListReverse(list3, node3)) {
                System.out.println("reverseDoubleList翻转错误");
            }

            DoubleNode node4 = generateRandomDoubleList(len, value);
            List<Integer> list4 = getDoubleListOriginOrder(node4);
            node4 = reverseDoubleListArr(node4);
            if (!checkDoubleListReverse(list4, node4)) {
                System.out.println("reverseDoubleListArr翻转错误!");
            }

        }
        System.out.println("测试结束");

    }

    public static class DoubleNode {
        public int value;
        //前一个节点
        public DoubleNode pre;
        //后一个节点
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }
}

package practice.code;

/**
 * @author wmx
 * @version 1.0
 * @className Code13_DeleteGivenValue
 * @description 删除链表上指定的value值
 * @date 2021/10/21 9:22
 */
public class Code13_DeleteGivenValue {
    //单链表删除
    public static Node removeValue(Node head, int value) {
        return head;
    }

    //for test
    public static void main(String[] args) {

    }

    public class Node {
        public int value;
        //node存放下一个节点的地址信息
        public Node next;

        public Node(int data) {
            value = data;
        }
    }
}

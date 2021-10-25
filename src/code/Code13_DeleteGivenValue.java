package code;

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
        //获取到第一个value值满足条件的节点
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //for test
    public static void main(String[] args) {

    }
}

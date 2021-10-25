package code;

/**
 * @author wmx
 * @version 1.0
 * @className DoubleNode
 * @description 双向链表
 * @date 2021/10/25 10:04
 */
public class DoubleNode {
    public int value;
    //前一个节点
    public DoubleNode pre;
    //后一个节点
    public DoubleNode next;

    public DoubleNode(int data) {
        value = data;
    }
}

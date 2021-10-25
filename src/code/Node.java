package code;

/**
 * @author wmx
 * @version 1.0
 * @className Node
 * @description 单链表节点数据定义
 * @date 2021/10/25 10:01
 */
public class Node {
    public int value;
    //node存放下一个节点的地址信息
    public Node next;

    public Node(int data) {
        value = data;
    }
}

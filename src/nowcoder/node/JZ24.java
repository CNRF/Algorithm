package nowcoder.node;

/**
 * JZ24 反转链表
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=23286
 *
 * @author wmx
 * @date 2022/5/6 22:56
 */
public class JZ24 {
    public ListNode ReverseList(ListNode head) {
        //处理特殊情况
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = null;
        //正常处理
        while (head != null) {
            //保存节点的原来下一个节点位置
            cur = head.next;
            //将head节点位置指向pre节点
            head.next = pre;
            //pre节点移动到当前位置
            pre = head;
            //head移动到下一个位置
            head = cur;
        }
        return pre;
    }
}

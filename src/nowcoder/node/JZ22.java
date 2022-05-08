package nowcoder.node;

/**
 * 链表中倒数最后k个结点
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=13&tqId=1377477
 *
 * @author wmx
 * @date 2022/5/8 10:04
 */
public class JZ22 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        //使用快慢指针，快指针比慢指针快K个节点
        ListNode fast = pHead;
        ListNode slow = pHead;
        //快指针先走k步
        while (k > 0) {
            if (fast != null) {
                fast = fast.next;
                k--;
            } else {
                //链表长度没有k
                return null;
            }
        }
        //快慢指针同时走，快指针节点为空时，慢节点正好在所处位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

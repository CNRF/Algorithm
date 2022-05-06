package nowcoder.node;

/**
 * 两个链表的第一个公共结点
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=23257
 *
 * @author wmx
 * @date 2022/5/6 23:35
 */
public class JZ52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0;
        int length2 = 0;
        //使用临时节点计算长度
        ListNode pHeadL1 = pHead1;
        ListNode pHeadL2 = pHead2;
        //计算两个链表的长度，让长链表先走 |length1-length2|步数
        while (pHeadL1 != null) {
            length1++;
            pHeadL1 = pHeadL1.next;
        }
        while (pHeadL2 != null) {
            length2++;
            pHeadL2 = pHeadL2.next;
        }
        //让长度长的链表先走
        int abs = length1 - length2;
        if (abs > 0) {
            while (abs != 0) {
                pHead1 = pHead1.next;
                abs--;
            }
        } else {
            while (abs != 0) {
                pHead2 = pHead2.next;
                abs++;
            }
        }
        //长度相同的时候同步移动，第一个相同直接返回，否则返回null
        while (pHead1 != null) {
            if (pHead1.val != pHead2.val) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            } else {
                return pHead1;
            }

        }
        return null;
    }
}

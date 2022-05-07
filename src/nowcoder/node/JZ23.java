package nowcoder.node;


/**
 * 链表中环的入口结点
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=23449
 *
 * @author wmx
 * @date 2022/5/7 21:26
 */
public class JZ23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //快慢指针，快指正走两步，慢指正走一步，最终如果快慢指针相同则说明有环
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            //在此处能进去if说明有环
            if (fast == slow) {
                //如果有环，那么快指针走过的路径就是a+b+c+b，
                //a为环之前长度 b为两个指针在换上相遇是环长度，c为慢指针还未走的环长度
                //慢指针走过的路径就是图中a+b，因为在相同的时间内，
                //快指针走过的路径是慢指针的2倍，所以这里有a+b+c+b=2*(a+b)，
                //整理得到a=c，也就是说图中a的路径长度和c的路径长度是一样的。
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}

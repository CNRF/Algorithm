package nowcoder.node;

/**
 * 合并两个排序的链表
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=23267
 *
 * @author wmx
 * @date 2022/5/6 23:09
 */
public class JZ25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        //处理特殊情况
        //list1和list2同时为空的情况
        if (list1 == null && list2 == null) {
            return null;
        }
        //list1为空。list2有值
        if (list1 == null) {
            return list2;
        }
        //list1有值，list2为空
        if (list2 == null) {
            return list1;
        }
        ListNode listNode = new ListNode(-1);
        //正常情况 两个同时有值
        //使用递归的方法,将较大剩下的继续merge
        if (list1.val > list2.val) {
            listNode = list2;
            listNode.next = Merge(list1, list2.next);
        } else {
            listNode = list1;
            listNode.next = Merge(list2, list1.next);
        }
        return listNode;
    }
}

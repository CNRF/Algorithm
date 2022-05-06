package nowcoder.node;

import java.util.ArrayList;
import java.util.Stack;

/**
 * JZ6 从尾到头打印链表
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=23278
 *
 * @author mingxing.wang
 * @date 2022/5/6 10:08
 */
public class JZ6 {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        return printListFromTailToHeadUseStack(listNode);
    }

    public ArrayList<Integer> printListFromTailToHeadReverseList(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    //将链表反转之后返回
    public ArrayList<Integer> printListFromTailToHeadReverseNode(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        return list;
    }


    //使用栈作为中间结构
    public ArrayList<Integer> printListFromTailToHeadUseStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

}

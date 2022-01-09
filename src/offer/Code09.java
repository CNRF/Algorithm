package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wmx
 * @version 1.0
 * @className Code09
 * @description https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @date 2022/1/4 11:18
 */
public class Code09 {

    class CQueue {
        //新增栈
        Deque<Integer> stack;
        //删除栈
        Deque<Integer> stack2;

        //初始化
        public CQueue() {
            stack = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        //在尾部新增元素
        public void appendTail(int value) {
            //在删除的时候判断，新增只在新增队列，
            // 只有删除队列没有数才会到新增队列获取新的数
            stack.push(value);
        }

        //在头部删除元素
        public int deleteHead() {
            //当第二个栈为空的时候
            if (stack2.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
            }
            if (stack2.isEmpty()) {
                return -1;
            } else {
                Integer pop = stack2.pop();
                return pop;
            }
        }
    }
}

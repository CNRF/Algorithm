package offer;

import java.util.Stack;

/**
 * @author wmx
 * @version 1.0
 * @className Code30
 * @description https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @date 2022/1/4 14:49
 */
public class Code30 {

    class MinStack {
        //存放数据
        Stack<Integer> stack;
        //存放最小数
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                int min = minStack.peek() > x ? x : minStack.peek();
                minStack.push(min);
            }
        }

        public void pop() {
            //stack和minStack大小一致
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}

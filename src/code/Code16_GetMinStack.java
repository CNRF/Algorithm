package code;

import java.util.Stack;

/**
 * @author wmx
 * @version 1.0
 * @className Code16_GetMinStack
 * @description 题目   实现特殊的栈，在栈基础功能上再实现返回最小值
 * 1）pop、push、getMin的操作的时间复杂度都是O（1）
 * 2) 设计的栈类型可以使用现成的栈结构
 * <p>
 * 解题思路
 * 准备两个栈， 一个存放数据栈，一个最小数栈
 * 在数据栈数据存放数据时，将最小栈栈顶数据拿出新放入栈的数据比较，
 * 哪个小放在最小数栈
 * 在数据栈数据为  2->3->2->5
 * 最小栈数据为      2->2->2->2
 * @date 2021/11/30 14:52`
 */
public class Code16_GetMinStack {
    public static class MyStack {
        //存放基本数据
        private Stack<Integer> stackData;
        //存放当前栈中最小数
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        /**
         * 对于压栈的数进行判断，如果最小数栈是空则直接进栈
         * 最小数栈不为空则与栈顶的数比较，，较小数进栈
         *
         * @param newNum
         */
        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getMin()) {
                this.stackMin.push(newNum);
            } else {
                this.stackMin.push(this.getMin());
            }
            this.stackData.push(newNum);
        }

        //获取最小数栈的栈顶值，为空栈抛出异常
        public int getMin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            int value = this.stackData.pop();
            this.stackMin.pop();
            return value;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        System.out.println(myStack.getMin());
        myStack.push(4);
        System.out.println(myStack.getMin());
        myStack.push(1);
        System.out.println(myStack.getMin());
        System.out.println(myStack.pop());
        System.out.println(myStack.getMin());
    }
}

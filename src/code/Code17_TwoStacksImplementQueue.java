package code;

import java.util.Stack;

/**
 * @author wmx
 * @version 1.0
 * @className Code17_TwoStacksImplementQueue
 * @description 通过已有的栈结构 实现队列
 * 图的宽度优先遍历（通过栈实现，默认是队列（非双端队列）实现）
 * @date 2021/11/30 15:04
 */
public class Code17_TwoStacksImplementQueue {

    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        //将push栈中的数据倒入到push栈中
        private void pushToPop() {
            if (stackPop.empty()) {
                while ((!stackPush.empty())) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        //向栈中添加元素
        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        //peek会删除栈顶节点
        public int peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("栈是空");
            }
            pushToPop();
            return stackPop.peek();
        }

        //不会删除栈顶节点
        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }
    }


    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}

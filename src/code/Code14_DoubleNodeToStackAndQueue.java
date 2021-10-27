package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wmx
 * @version 1.0
 * @className Code14_DoubleNodeToStackAndQueue
 * @description 使用双向链表实现队列和栈
 * @date 2021/10/27 10:00
 */
public class Code14_DoubleNodeToStackAndQueue {
    //双向链表结构
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    //双向链表相关操作
    public static class DoubleEndsQueue<T> {
        //临时记录头尾节点
        public Node<T> head;
        public Node<T> tail;

        /**
         * 从头节点添加数据
         *
         * @param value 添加的数据
         */
        public void addFromHead(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                //链表为空的时候
                head = cur;
                tail = cur;
            } else {
                //链表不为空
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        /**
         * 从尾节点添加数据
         *
         * @param value 添加的数据
         */
        public void addFromBottom(T value) {
            Node<T> cur = new Node<>(value);
            if (head == null) {
                //链表为空的时候
                head = cur;
                tail = cur;
            } else {
                //链表不为空
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        /**
         * 从头节点弹出数据
         *
         * @return
         */
        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        /**
         * 尾节点弹出数据
         *
         * @return
         */
        public T popFromBottom() {
            if (head == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        /**
         * 判断链表是否为空
         *
         * @return
         */
        public boolean isEmpty() {
            return head == null;
        }
    }

    /**
     * 通过双向链表实现
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    /**
     * 双向链表实现队列
     *
     * @param <T>
     */
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromBottom();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }


    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}

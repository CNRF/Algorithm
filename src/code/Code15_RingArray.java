package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code15_RingArray
 * @description 数组实现队列
 * <p>
 * 通过两个标识位来控制添加和删除，不需要追赶感
 * @date 2021/11/30 14:46
 */
public class Code15_RingArray {
    public static class MyQueue {
        private int[] arr;
        //end 进来的数放哪
        private int pushi;
        // begin  弹出的数放在哪
        private int polli;
        //数组实际长度
        private int size;
        //数组限定长度
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }
}

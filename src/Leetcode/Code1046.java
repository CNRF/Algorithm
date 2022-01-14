package Leetcode;

import java.util.PriorityQueue;

/**
 * @author wmx
 * @version 1.0
 * @className Code1046
 * @description https://leetcode-cn.com/problems/last-stone-weight/
 * @date 2022/1/13 14:07
 */
public class Code1046 {
    public static int lastStoneWeight(int[] stones) {
        int res = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size() > 1) {
            int a = priorityQueue.poll();
            int b = priorityQueue.poll();
            if (a > b) {
                priorityQueue.offer(a - b);
            }
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 8, 1};
        lastStoneWeight(nums);
    }
}

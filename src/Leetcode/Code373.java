package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wmx
 * @version 1.0
 * @className Code373
 * @description https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * @date 2022/1/14 9:14
 */
public class Code373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //大根堆
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> (b.get(0) + b.get(1) - (a.get(0) + b.get(0))));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                queue.add(pair);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        while (queue.size() > 0) {
            res.add(queue.poll());
        }
        return res;
    }
}

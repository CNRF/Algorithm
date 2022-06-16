package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/k-diff-pairs-in-an-array/">https://leetcode.cn/problems/k-diff-pairs-in-an-array/</a>
 *
 * @author mingxing.wang
 */
public class Code532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int ans = 0;
        for (int i : nums) {
            if (map.get(i) == 0) continue;
            if (k == 0) {
                if (map.get(i) > 1) ans++;
            } else {
                int a = i - k, b = i + k;
                if (map.getOrDefault(a, 0) > 0) ans++;
                if (map.getOrDefault(b, 0) > 0) ans++;
            }
            map.put(i, 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        Code532 code532 = new Code532();
        int[] ints = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k = 3;
        int pairs = code532.findPairs(ints, k);
    }
}

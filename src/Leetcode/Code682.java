package Leetcode;

/**
 * https://leetcode-cn.com/problems/baseball-game/
 *
 * @author wmx
 * @version 1.0
 * @className Code682
 * @date 2022/3/26 23:14
 */
public class Code682 {
    static int[] nums = new int[1010];

    public int calPoints(String[] ops) {
        int n = ops.length, idx = 0;
        for (int i = 0; i < n; i++, idx++) {
            if (ops[i].equals("+")) nums[idx] = nums[idx - 1] + nums[idx - 2];
            else if (ops[i].equals("D")) nums[idx] = nums[idx - 1] * 2;
            else if (ops[i].equals("C")) idx -= 2;
            else nums[idx] = Integer.parseInt(ops[i]);
        }
        int ans = 0;
        for (int i = 0; i < idx; i++) ans += nums[i];
        return ans;
    }
}

package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code198
 * @description https://leetcode-cn.com/problems/house-robber/solution/
 * @date 2022/1/11 15:38
 */
public class Code198 {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}

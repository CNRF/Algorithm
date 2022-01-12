package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code70
 * @description https://leetcode-cn.com/problems/climbing-stairs/solution/70pa-lou-ti-yi-ju-wang-zhe-de-shi-jian-j-884o/
 * @date 2022/1/11 14:44
 */
public class Code70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

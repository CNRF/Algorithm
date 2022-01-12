package Leetcode;

import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code120
 * @description https://leetcode-cn.com/problems/triangle/
 * @date 2022/1/11 17:34
 */
public class Code120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        //存放到某一节点的最小路径
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            //最左最右节点
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int minTotal = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, dp[size - 1][i]);
        }
        return minTotal;
    }
}

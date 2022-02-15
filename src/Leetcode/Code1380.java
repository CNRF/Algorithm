package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingxing.wang
 * @version 1.0
 * @className Code1280
 * @description https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * @date 2022/2/15 10:28
 */
public class Code1380 {
    int N = 55;
    int[] row = new int[N], col = new int[N];
    /**
     *  先获取当前行中最小值，之后根据最小值来获取列最大值，不是当前行则不是幸运值
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            row[i] = 100001;
            for (int j = 0; j < m; j++) {
                //获取当前行最小值和当前列最大值
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = matrix[i][j];
                if (t == row[i] && t == col[j]) {
                    ans.add(t);
                }
            }
        }
        return ans;
    }
}

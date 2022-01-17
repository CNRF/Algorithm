package Leetcode;

import java.util.Arrays;

/**
 * @author wmx
 * @version 1.0
 * @className Code1220
 * @description https://leetcode-cn.com/problems/count-vowels-permutation/
 * @date 2022/1/17 9:35
 */
public class Code1220 {
    static int MOD = (int) 1e9 + 7;

    public static int countVowelPermutation(int n) {
        long[][] f = new long[n][5];
        //将数组第一行都填充1，即为1的时候的数据
        Arrays.fill(f[0], 1);
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][1];
            f[i][1] = f[i - 1][0] + f[i - 1][2];
            f[i][2] = f[i - 1][0] + f[i - 1][1] + f[i - 1][3] + f[i - 1][4];
            f[i][3] = f[i - 1][2] + f[i - 1][4];
            f[i][4] = f[i - 1][0];
            for (int j = 0; j < 5; j++) f[i][j] %= MOD;
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) ans += f[n - 1][i];
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        countVowelPermutation(5);
    }
}

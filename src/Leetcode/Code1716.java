package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code1716
 * @description https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/solution/
 * @date 2022/1/16 10:13
 */
public class Code1716 {
    public int totalMoney(int n) {
        int a = n / 7;
        int b = n % 7;
        return a * (a + 7) * 7 / 2 + (b + 1) * b / 2 + a * b;

    }
}

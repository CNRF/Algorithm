package Leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-missing-observations/
 *
 * @author wmx
 * @version 1.0
 * @className Code2028
 * @date 2022/3/27 21:45
 */
public class Code2028 {
    public static void main(String[] args) {
        int[] rolls = {4, 2, 2, 5, 4, 5, 4, 5, 3, 3, 6, 1, 2, 4, 2, 1, 6, 5, 4, 2, 3, 4, 2, 3, 3, 5, 4, 1, 4, 4, 5, 3, 6, 1, 5, 2, 3, 3, 6, 1, 6, 4, 1, 3};
        int means = 2;
        int n = 53;
        int[] ints = new Code2028().missingRolls(rolls, 2, 53);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = (rolls.length + n) * mean;
        for (int roll : rolls) {
            sum = sum - roll;
        }
        //缺失的数据大于6*n或者小于n则不可能出现
        //不是<0是因为骰子最小点数为1
        if (sum < n || sum > 6 * n) {
            return new int[]{};
        }
        //根据sum构造剩余的数
        int[] ints = new int[n];
        Arrays.fill(ints, sum / n);
        //sum / n向下取整会出现小于的情况
        if ((sum / n) * n < sum) {
            int d = sum - (sum / n) * n;
            int idx = 0;
            while (d-- > 0) {
                ints[idx++]++;
            }
        }
        return ints;
    }
}

package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code24_CountOfRangeSum
 * @description LeetCode原题连接  https://leetcode-cn.com/problems/count-of-range-sum/
 * 问题:给定一个数组arr，两个整数lower和upper，返回arr中有所少个子数组的累加和在[lower,upper]之间
 * 例子:
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 * <p>
 * 解题思路:
 * 1：将数组转化为前N个数之和的一个数组，如例子 转化之后[-2,3,2]
 * 2. 将转化之后的数据进行归并排序，在归并排序中
 * @date 2021/12/6 14:53
 */
public class Code24_CountOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //sum存放的是累加和，long类型防止溢出
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return process(sum, 0, sum.length - 1, lower, upper);
    }

    private static int process(long[] sum, int L, int R, int lower, int upper) {
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }
        int M = L + ((R - L) >> 1);
        return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper) + merge(sum, L, M, R, lower, upper);
    }

    private static int merge(long[] arr, int L, int M, int R, int lower, int upper) {
        int ans = 0;
        int windowL = L;
        int windowR = L;
        // [windowL, windowR)
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }
        long[] help = new long[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int i = countRangeSum(nums, -2, 2);
        System.out.println(i);
    }
}

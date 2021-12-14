package code;

/**
 * @author wmx
 * @version 1.0
 * @className Code24_CountOfRangeSum
 * @description LeetCode原题连接  https://leetcode-cn.com/problems/count-of-range-sum/
 * 问题:给定一个数组arr，两个整数lower和upper，返回arr中有所少个子数组（必须连续）的累加和在[lower,upper]之间
 * 例子:
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]（对应[-2]）、[2,2]([-1]) 和 [0,2]([-2,5,-1]) ，对应的区间和分别是：-2 、-1 、2 。
 * <p>
 * 解题思路:
 * 1：将数组转化为前N个数之和（前缀和）的一个数组，如例子 转化之后[-2,3,2]
 * 2:题目转为为 求前缀和数组中有多少个子数组以当前位置结尾在[X-upper，X-lower]如：例子中则是求以2结尾的子数组中累加和有多少在[2-2，2-（-2）]上
 * 2. 将转化之后的数据进行归并排序，
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

    /**
     * @param sum   前缀和子数组
     * @param L     数组左边界
     * @param R     数组有边界
     * @param lower 要求和的下边界
     * @param upper 要求和的下边界
     * @return 满足条件的子数组数量
     */
    private static int process(long[] sum, int L, int R, int lower, int upper) {
        //数组长度为1的判断
        if (L == R) {
            return sum[L] >= lower && sum[L] <= upper ? 1 : 0;
        }
        //进行归并排序
        int M = L + ((R - L) >> 1);
        //process循环调用之后最终都是长度为1的数组
        return process(sum, L, M, lower, upper) + process(sum, M + 1, R, lower, upper) + merge(sum, L, M, R, lower, upper);
    }

    private static int merge(long[] arr, int L, int M, int R, int lower, int upper) {

        int ans = 0;
        int windowL = L;
        int windowR = L;
        // [windowL, windowR)
        /**
         * 利用归并排序的思想
         * 如果输入的数组是[2,5,8,9,11,15]（左数组）,[6,7,7,8,10,11](有数组），目标是[-1,2]
         * 则 6 的时候，查左边windowR和windowL在[4,7]之间的数有 1个[5]
         *     7的时候，查左边windowR和windowL在[5,8]之间的数有2个[5,8]
         *
         */
        for (int i = M + 1; i <= R; i++) {
            long min = arr[i] - upper;
            long max = arr[i] - lower;
            //查找窗口左边界
            while (windowR <= M && arr[windowR] <= max) {
                windowR++;
            }
            //窗口右边界
            while (windowL <= M && arr[windowL] < min) {
                windowL++;
            }
            ans += Math.max(0, windowR - windowL);
        }
        //正常的归并排序
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

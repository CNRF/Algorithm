package practice.code;

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
        return 0;
    }


    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int i = countRangeSum(nums, -2, 2);
        System.out.println(i);
    }
}

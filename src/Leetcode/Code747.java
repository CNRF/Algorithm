package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code747
 * @description https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * @date 2022/1/13 10:24
 */
public class Code747 {
    public static int dominantIndex(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int first = nums[0];
        int second = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] >= first) {
                second = first;
                index = i;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return second << 1 > first ? -1 : index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        int i = dominantIndex(nums);
        System.out.println(i);
    }
}

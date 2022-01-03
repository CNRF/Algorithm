package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code977
 * @description https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @date 2022/1/1 9:15
 */
public class Code977 {

    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while (l <= r) {
            if (nums[l] * nums[l] <= nums[r] * nums[r]) {
                result[index--] = nums[r] * nums[r--];
            } else {
                result[index--] = nums[l] * nums[l++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-5, -1, 1, 3};
        int[] ints1 = sortedSquares(ints);
        for (int i : ints1) {
            System.out.println(i);
        }

    }
}

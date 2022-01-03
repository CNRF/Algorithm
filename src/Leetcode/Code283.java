package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code283
 * @description https://leetcode-cn.com/problems/move-zeroes/
 * @date 2022/1/2 11:28
 */
public class Code283 {

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 0, 3, 12};
        moveZeroes(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

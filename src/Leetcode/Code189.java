package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code189
 * @description https://leetcode-cn.com/problems/rotate-array/
 * @date 2022/1/1 9:30
 */
public class Code189 {
    //直接进行数组交换
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % n] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, n);
    }

    //将数组先全部翻转之后在根据K值分割数组范别翻转
    public static void rotate1(int[] nums, int k) {
        //保证K的长度比数组长度短
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate1(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}

package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code334
 * @description
 * @date 2022/1/12 11:08
 */
public class Code334 {
    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (nums[i] > second) {
                return true;
            } else if (nums[i] > first) {
                second = nums[i];
            } else {
                first = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1};
        boolean b = increasingTriplet(array);
        System.out.println(b);
    }
}

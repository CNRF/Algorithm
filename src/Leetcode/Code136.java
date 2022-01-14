package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code136
 * @description https://leetcode-cn.com/problems/single-number/
 * @date 2022/1/13 9:58
 */
public class Code136 {
    public static int singleNumber(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }
}

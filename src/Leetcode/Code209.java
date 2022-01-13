package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code209
 * @description https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @date 2022/1/12 14:49
 */
public class Code209 {
    public static int minSubArrayLen(int target, int[] nums) {
        //定义左右窗口位置
        int i = 0, j = 0;
        int length = nums.length;
        int res = 0;
        int sum = 0;
        while (j < length) {
            sum = sum + nums[j];
            if (sum == target) {
                sum = sum - nums[i];
                res = res == 0 ? j - i + 1 : Math.min(res, j - i + 1);
                i++;
                j++;
            } else if (sum > target) {
                sum = sum - nums[i];
                res = res == 0 ? j - i + 1 : Math.min(res, j - i + 1);
                i++;
                sum = sum - nums[j];
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1, 4, 4};
        int minSubArrayLen = minSubArrayLen(target, nums);
        System.out.println(minSubArrayLen);
    }
}

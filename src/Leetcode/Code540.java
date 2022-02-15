package Leetcode;

/**
 * @author mingxing.wang
 * @version 1.0
 * @className Code
 * @description https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * @date 2022/2/14 14:54
 */
public class Code540 {
    /**
     * 使用异或（1^1=0）直接获取相关数据
     *
     * @param nums 数组
     * @return 返回唯一出现奇数次的数
     */
    public int singleNonDuplicate(int[] nums) {

        int num = 0;
        for (int i : nums) {
            num = num ^ i;
        }
        return num;
    }

    /**
     * 使用二分法查找相关数据
     *
     * @param nums 数组
     * @return 返回只出现一次的数
     */
    public int singleNonDuplicate2(int[] nums) {
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (mid % 2 == 0) {
                if (mid + 1 < length && nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[r];
    }
}

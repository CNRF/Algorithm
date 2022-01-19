package Leetcode;

import java.util.HashSet;

/**
 * @author wmx
 * @version 1.0
 * @className Code219
 * @description https://leetcode-cn.com/problems/contains-duplicate-ii/
 * @date 2022/1/19 15:06
 */
public class Code219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            //去除K大小窗口的数据的左边数据
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            //判断新增数据是否在原来就有
            if (set.contains(nums[i])) {
                return true;
            }
            //新增数据
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        boolean b = containsNearbyDuplicate(nums, 1);
        System.out.println(b);
    }
}

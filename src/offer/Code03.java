package offer;

import java.util.HashSet;

/**
 * @author wmx
 * @version 1.0
 * @className Code03
 * @description https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @date 2022/1/6 21:41
 */
public class Code03 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (integers.contains(num)) {
                return num;
            }
            integers.add(num);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        //根据条件  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
        // 可以判定每一个数都在nums中有下标相同的位置
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}

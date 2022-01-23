package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code2029
 * @description https://leetcode-cn.com/problems/stone-game-ix/
 * @date 2022/1/20 9:11
 */
public class Code2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] nums = new int[3];
        for (int stone : stones) {
            //统计是余数是0，1，2的数组中出现的个数
            nums[stone % 3]++;
        }
        return nums[0] % 2 == 0 ? !(nums[1] == 0 || nums[2] == 0) : !(Math.abs(nums[1] - nums[2]) <= 2);

    }
}

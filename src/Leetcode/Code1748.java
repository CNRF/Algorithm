package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code1748
 * @description https://leetcode-cn.com/problems/sum-of-unique-elements/
 * @date 2022/2/6 10:53
 */
public class Code1748 {

    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        int res = 0;
        for (int i : nums) {
            if (cnt[i] == -1) continue;
            else if (cnt[i] == 0) {
                res += i;
                cnt[i] = 1;
            } else if (cnt[i] == 1) {
                res -= i;
                cnt[i] = -1;
            }
        }
        return res;
    }
}

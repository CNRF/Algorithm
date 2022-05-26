package Leetcode;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/solution/">1004. 最大连续1的个数 III</a>
 *
 * @author mingxing.wang
 * @date 2022/5/26 11:13
 */
public class Code1004 {
    public int longestOnes(int[] nums, int k) {
        //数组长度
        int length = nums.length;
        //滑动窗口左边界
        int l = 0;
        //滑动窗口有边界
        int r = 0;
        //最大长度
        int res = 0;
        //当前窗口中有多少个0
        int zeros = 0;
        while (r < length) {
            //r会一直向前走
            if (nums[r] == 0) {
                //nums[r]为0的时候标识位增加
                zeros++;
            }
            while (zeros > k) {
                //当超过最大的翻转次数，此时左边界移动，直到zeros<k
                if (nums[l++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}

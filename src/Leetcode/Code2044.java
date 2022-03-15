package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code2044
 * @description https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * @date 2022/3/15 23:08
 */
public class Code2044 {
    public static void main(String[] args) {
        Code2044 code2044 = new Code2044();
        int[] ints = {3, 2, 1, 5};
        int i = code2044.countMaxOrSubsets(ints);
        System.out.println(i);
    }

    int max = 0, ans = 0;
    int[] nums;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int u, int val) {

        //数组最后的位置
        if (u == nums.length) {
            if (val > max) {
                //此处说明前面出现的不是最大的数，因此充值状态
                max = val;
                ans = 1;
            } else if (val == max) {
                ans++;
            }
            return;
        }
        //此处为不选取数组上u位置的数
        dfs(u + 1, val);
        //此处为选取数组上u位置的数 0|1=1
        dfs(u + 1, val | nums[u]);
    }

}

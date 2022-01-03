package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className code11
 * @description
 * @date 2021/12/2 11:07
 */
public class code11 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 5, 18, 17, 6};
        int i = new Solution().maxArea(ints);
        System.out.println(i);
    }

    /*
    *
    * class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                Math.max(res, (j - i) * height[i++]):
                Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
    * */
    static class Solution {
        public int maxArea(int[] height) {
            if (height.length < 2) {
                return 0;
            }
            int L = 0;
            int R = height.length - 1;
            int otherSize = 0;
            int size = 0;
            while (R > L) {
                size = height[L] < height[R] ? Math.max(size, (R - L) * height[L++]) : Math.max(size, (R - L) * height[R--]);
            }
            return size;
        }

    }
}

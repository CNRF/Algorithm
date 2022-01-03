package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code1146
 * @description
 * @date 2021/12/9 19:47
 */
public class Code1446 {
    public static int maxPower(String s) {
        //将strings转为数组
        char[] chars = s.toCharArray();
        //滑动窗口思想
        int r = 0, l = 0;
        //当前数组中最大重复数量
        int length = 1;
        while (r < chars.length) {
            while (r < chars.length && chars[l] == chars[r]) {
                r++;
            }
            length = Math.max(length, r - l);
            //当出现两个连续，第三个不连续，直接将左边界移到第三个数位置
            l = r;
            r++;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abbcccddddeeeeedcba";
        int i = maxPower(s);
        System.out.println(i);
    }
}

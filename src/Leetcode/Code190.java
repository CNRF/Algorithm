package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code190
 * @description https://leetcode-cn.com/problems/reverse-bits/
 * @date 2022/1/13 9:38
 */
public class Code190 {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res | ((n & 1) << (31 - i));
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = reverseBits(43261596);
        System.out.println(i);
    }
}

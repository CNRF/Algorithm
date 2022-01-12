package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code191
 * @description https://leetcode-cn.com/problems/number-of-1-bits/submissions/
 * @date 2022/1/12 10:32
 */
public class Code191 {
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            //res++ 不用这个是因为右移可能最后一位为0，只有是1的才+1
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = hammingWeight(11);
        System.out.println(i);
    }
}

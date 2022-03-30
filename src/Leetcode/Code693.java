package Leetcode;

/**
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 *
 * @author mingxing.wang
 * @date 2022/3/28 12:51
 */
public class Code693 {
    public boolean hasAlternatingBits(int n) {
        /*
         * 如果n的二进制是交替出现则 n>>1也是交替出现并且和n二进制是错位的
         * n^(n>>1)则二进制则会是形如：0000111111111
         * x+1 则会出现000100000000
         * 则x^(x+1)=0
         * */
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }

    public static void main(String[] args) {
        boolean b = new Code693().hasAlternatingBits(4);
        System.out.println(b);
    }
}

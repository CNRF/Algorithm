package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code231A2
 * @description https://leetcode-cn.com/problems/power-of-two/
 * @date 2022/1/12 10:17
 */
public class Code231A2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & n - 1) == 0;
    }
}

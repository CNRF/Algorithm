package Leetcode;

/**
 * https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 * @author mingxing.wang
 * @date 2022/3/14 18:10
 */
public class Code1780 {
    public static  boolean checkPowersOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n%3==0){
            return checkPowersOfThree(n/3);
        }
        if (n % 3 == 1) {
            return checkPowersOfThree((n-1)/3);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

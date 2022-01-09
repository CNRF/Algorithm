package offer;

/**
 * @author wmx
 * @version 1.0
 * @className Code58
 * @description https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @date 2022/1/5 15:40
 */
public class Code58 {
    public static String reverseLeftWords(String s, int n) {
        String s1 = s + s;
        return s1.substring(n, n + s.length());
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = reverseLeftWords(s, 2);
        System.out.println(s1);
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

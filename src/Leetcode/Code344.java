package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code344
 * @description https://leetcode-cn.com/problems/reverse-string/
 * @date 2022/1/3 13:54
 */
public class Code344 {
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            swap(s, left++, right--);
        }

    }

    public static void swap(char[] s, int left, int right) {
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}

package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code557
 * @description https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * @date 2022/1/3 14:02
 */
public class Code557 {
    public static String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            stringBuffer.append(reverseString(s2.toCharArray()));
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

    public static String reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            swap(s, left++, right--);
        }
        return new String(s);
    }

    public static void swap(char[] s, int left, int right) {
        char temp = s[right];
        s[right] = s[left];
        s[left] = temp;
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}

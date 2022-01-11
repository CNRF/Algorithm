package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wmx
 * @version 1.0
 * @className Code784
 * @description https://leetcode-cn.com/problems/letter-case-permutation/submissions/
 * @date 2022/1/10 11:48
 */
public class Code784 {
    static List<String> list = new ArrayList<>();

    public static List<String> letterCasePermutation(String s) {
        getStr(0, s, new StringBuffer());
        return list;
    }

    private static void getStr(int index, String s, StringBuffer sb) {
        if (index == s.length()) {
            list.add(String.valueOf(sb));
            return;
        }
        char ch = s.charAt(index);
        sb.append(ch);
        //此处是保持原字母进行迭代
        getStr(index + 1, s, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (!Character.isDigit(ch)) {
            ch = (char) (ch - 'a' >= 0 ? ch - 32 : ch + 32);
            sb.append(ch);
            //此处是改变字母大小写进行迭代
            getStr(index + 1, s, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "A1b2";
        List<String> stringList = letterCasePermutation(s);
        for (String s1 : stringList) {
            System.out.println(s1);
        }
    }
}

package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * N字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author mingxing.wang
 * @date 2022/3/1 14:32
 */
public class Code06 {
    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 3);
        System.out.println(paypalishiring);
    }

    public static String convert(String s, int numRows) {
        //给定行数为1时直接返回数组
        if (numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                //此处控制数组下标方向
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}

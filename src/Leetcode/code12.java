package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className code12
 * @description
 * @date 2021/12/2 11:34
 */
public class code12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
    }

    static class Solution {
        public String intToRoman(int num) {
            String s = "";
            //建立缓存
            int[] ints = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
            String[] strings = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
            while (num != 0) {
                for (int i = ints.length - 1; i >= 0; i--) {
                    if (num >= ints[i]) {
                        s = s + strings[i];
                        num -= ints[i];
                        i++;
                    }
                }
            }
            return s;
        }
    }
}

package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code03
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @date 2022/1/5 9:23
 */
public class Code03 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        //题目中只存在字母，符号，数字，考虑用数组代理hash表缓存提高效率
        int[] nums = new int[128];
        //将字符串转化为数组
        char[] chars = s.toCharArray();
        //left左指针，right为右指针
        int left = 0;
        int right = 0;
        //length为存放长度变量
        int length = 0;
        while (right < n) {
            //将对应字符的位置存放数量表示出现
            nums[(byte) chars[right]]++;
            //数组对应字符出现次数大于1
            while (nums[(byte) chars[right]] > 1) {
                //此时需要移动左指针,同时操作数组缓存将对应位置的数目-1
                nums[(byte) chars[left]]--;
                left++;
            }
            //更新长度
            length = Math.max(length, right - left + 1);
            //右指针右移
            right++;
        }
        return length;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code567
 * @description https://leetcode-cn.com/problems/permutation-in-string/
 * @date 2022/1/5 9:58
 */
public class Code567 {
    public static boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (s1 == null || s1 == null || length1 > length2) {
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] nums1 = new int[32];
        int[] nums2 = new int[32];
        for (int i = 0; i < length1; i++) {
            //将s1的字符串字母出现的次数缓存到数组中
            nums1[(byte) chars1[i] - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < length2) {
            nums2[chars2[right] - 'a']++;
            while (left <= right && nums1[chars2[right] - 'a'] < nums2[chars2[right] - 'a']) {
                nums2[chars2[left] - 'a'] = nums2[chars2[left] - 'a'] - 1;
                left++;
            }
            if (right - left + 1 == length1) {
                return true;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }
}

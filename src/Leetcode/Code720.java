package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 *
 * @author wmx
 * @version 1.0
 * @className Code720
 * @date 2022/3/17 22:38
 */
public class Code720 {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Code720 code720 = new Code720();
        System.out.println(code720.longestWord(words));
    }

    //TODO 考虑用字典树解决
    public String longestWord(String[] words) {
        //将字符串排序长度由小向大排序
        Arrays.sort(words, (a, b) ->
                {
                    if (a.length() != b.length()) {
                        return a.length() - b.length();
                    }
                    // 相同长度下把字典序较大的排在前面 （apply在apple前面）
                    return b.compareTo(a);
                }
        );
        for (String word : words) {
            System.out.println(word);
        }
        String ans = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                ans = word;
                // 注意是逐步多一，所以，这个添加要放在if里面
                set.add(word);
            }
        }
        return ans;
    }
}

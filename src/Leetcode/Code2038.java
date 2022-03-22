package Leetcode;

/**
 * https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 *
 * @author wmx
 * @version 1.0
 * @className Code2038
 * @date 2022/3/22 0:11
 */
public class Code2038 {
    public static void main(String[] args) {
        boolean aaaabbbb = new Code2038().winnerOfGame("");
        System.out.println(aaaabbbb);
    }

    //此题本质上是找到连续的AAA和BBB在除开收尾位置的元素哪一个出现的最多
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        char[] c = colors.toCharArray();
        for (int i = 1; i < c.length - 1; i++) {
            if (c[i] == 'A' && c[i - 1] == 'A' & c[i + 1] == 'A') {
                alice++;
            }
            if (c[i] == 'B' && c[i - 1] == 'B' & c[i + 1] == 'B') {
                bob++;
            }
        }
        return alice > bob;
    }
}

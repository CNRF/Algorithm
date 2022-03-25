package Leetcode;

/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 *
 * @author wmx
 * @version 1.0
 * @className Code172
 * @date 2022/3/25 22:28
 */
public class Code172 {
    /*
     * 容易发现在 1 - 9 中（只考虑个位上的数）只有偶数与 5 相乘会出现一个 0，
     * 而究其根本，是2×5=10 产生的 0，所以结果就是 n! 中能分解出的 2 和 5 的数量，
     * 取小的一个。因为 2 与 5 是互质的，两者的分解互不干扰，而且不难看出 2 的数量必定比 5 要多，
     * 所以我们只需找 n!中质因数分解 5 的数量即可。
     * */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

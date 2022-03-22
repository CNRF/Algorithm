package Leetcode;

/**
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 *
 * @author wmx
 * @version 1.0
 * @className Code440
 * @date 2022/3/23 0:52
 */
public class Code440 {
    public int findKthNumber(int n, int k) {
        // 当前遍历到的数字，从1（根）出发
        long cur = 1;
        // 从1出发开始往后按字典序从小到大的顺序走k-1步到达的就是 字典序的第K小数字
        k = k - 1;
        while (k > 0) {
            int nodes = getNode(n, cur);
            if (k >= nodes) {// 向右侧节点走：字典序上升nodes位
                k = k - nodes;
                cur++; // 当前数字 cur = cur + 1
            } else { // 向下往最左孩子节点走:字典序上升1位
                k = k - 1;  // 当前数字 cur = cur * 10
                cur = cur * 10;
            }
        }
        return (int) cur;
    }

    //计算以cur为根的子节点数目，所有节点的值的字典序都必须小于n
    private int getNode(int n, long cur) {
        //记录此根节点右侧的值
        long next = cur + 1;
        //记录子树的全部节点
        long totalNums = 0;
        while (cur <= n) {
            totalNums = totalNums + Math.min(n - cur + 1, next - cur);
            next = next * 10;
            cur = cur * 10;
        }
        return (int) totalNums;
    }
}

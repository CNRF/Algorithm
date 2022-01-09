package Leetcode;

/**
 * @author wmx
 * @version 1.0
 * @className Code617
 * @description https://leetcode-cn.com/problems/merge-two-binary-trees/
 * @date 2022/1/7 14:23
 */
public class Code617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

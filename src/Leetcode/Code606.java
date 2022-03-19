package Leetcode;

/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 *
 * @author wmx
 * @version 1.0
 * @className Code606
 * @date 2022/3/19 14:46
 */
public class Code606 {
    StringBuffer sb = new StringBuffer();

    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);

    }

    //通过dfs（递归）完成
    void dfs(TreeNode node) {
        //都打出节点的左边括号，最后返回时候截取即可
        sb.append("(");
        sb.append(node.val);
        if (node.left != null) {
            dfs(node.left);
        } else if (node.right != null) {
            //如果有右节点，()不能省略
            sb.append("()");
        }
        if (node.right != null) {
            dfs(node.right);
        }
        sb.append(")");
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

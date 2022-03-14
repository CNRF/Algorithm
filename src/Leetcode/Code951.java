package Leetcode;

/**
 * https://leetcode-cn.com/problems/flip-equivalent-binary-trees/
 *
 * @author mingxing.wang
 * @date 2022/3/14 17:56
 */
public class Code951 {
    /**
     * 书的节点定义
     */
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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1==null||root2==null){
            return root1 ==root2;
        }
        if (root1.val!= root2.val){
            return false;
        }
        //此处比较root1和root2左右节点是否相同的情（深度优先）
        return ((flipEquiv(root1.left, root2.left)&&flipEquiv(root1.right, root2.right))
                ||(flipEquiv(root1.right, root2.left)&&flipEquiv(root1.left,root2.right)));
    }
}
